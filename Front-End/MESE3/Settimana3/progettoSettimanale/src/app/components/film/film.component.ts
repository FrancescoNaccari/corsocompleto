import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AuthService } from 'src/app/auth/auth.service';
import { AuthData } from 'src/app/interface/auth-data.interface';
import { Movies } from 'src/app/interface/movies.interface';
import { FilmService } from 'src/app/service/film.service';
import { SocialUser } from '@abacritt/angularx-social-login';

@Component({
  selector: 'app-film',
  templateUrl: './film.component.html',
  styleUrls: ['./film.component.scss']
})
export class FilmComponent implements OnInit {

  user!:AuthData|null|SocialUser;

  constructor( private mvSrv: FilmService, private authSrv: AuthService) {
    this.authSrv.user$.subscribe((value) => {
      this.user = value;
    })
  }

  film!: Movies[]

  checkTypeOfAuthData(object: any): object is AuthData {
    return 'user' in object
  }

  checkTypeOfSocialUser(object:any): object is SocialUser {
    return 'id' in object
  }

  ngOnInit(): void {
    this.mvSrv.getFilms().subscribe(async (data) => {
      this.film = data
      if (this.user) {
        let favorites:any;
        if (this.checkTypeOfAuthData(this.user)) {
          let favorites2 = await this.mvSrv.getFilmsFavorites(Number(this.user.user.id))
          favorites = favorites2
        } else if (this.checkTypeOfSocialUser(this.user)) {
          let favorites2 = await this.mvSrv.getFilmsFavorites(Number(this.user.id))
          favorites = favorites2
        }
        for (let i=0; i < favorites.length; i++) {
          let index = this.film.findIndex((value) => value.id === favorites[i].movieId)
          if (index !== -1) {
            this.film[index].video = true
          }
        }
      }
    })
    
  }

  favourite(fav: Movies) {
    if (this.user) {
      let index = this.film.findIndex((value) => value.id === fav.id)
      if (index !== -1) {
        this.film[index].video = !this.film[index].video
      }
      if (this.checkTypeOfAuthData(this.user)) {
        this.mvSrv.toggle(fav.id, Number(this.user.user.id));
      } else if (this.checkTypeOfSocialUser(this.user)) {
        this.mvSrv.toggle(fav.id, Number(this.user.id));
      }
    }
  }
}

