import { Component } from '@angular/core';
import { AuthService } from 'src/app/auth/auth.service';
import { AuthData } from 'src/app/interface/auth-data.interface';
import { SocialUser } from '@abacritt/angularx-social-login';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {
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

}
