import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {
loggedIn:boolean=false
constructor(private auth:AuthService, private router:Router)  {
  auth.isLoggendIn.subscribe((value)=>{
    this.loggedIn=value
  })
}
logIn(){
this.router.navigate(['/login'])
}
logOut(){
this.auth.logout()
}


}
