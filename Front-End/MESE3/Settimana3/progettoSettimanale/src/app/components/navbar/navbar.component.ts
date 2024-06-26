import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth/auth.service';
import { AuthData } from 'src/app/interface/auth-data.interface';
import { SocialUser } from '@abacritt/angularx-social-login';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit{

  user!: AuthData | null | SocialUser

  constructor(private authsrv: AuthService) {}

  ngOnInit(): void {
    this.authsrv.user$.subscribe((data) => {
      this.user = data
    })
  }
  logout() {
    this.authsrv.logout()
  }

  checkTypeOfAuthData(object: any): object is AuthData {
    return 'user' in object
  }

  checkTypeOfSocialUser(object:any): object is SocialUser {
    return 'id' in object
  }

}
