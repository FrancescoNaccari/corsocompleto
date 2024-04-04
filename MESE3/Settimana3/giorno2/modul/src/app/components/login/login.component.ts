import { Component } from '@angular/core';
import {  NgForm } from '@angular/forms';
import {  Router } from '@angular/router';
import { User } from 'src/app/interface/user.interface';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
user:User={
  username:'',
  password:'',
}
constructor(private auth:AuthService, private router:Router){}
onSubmit(form:NgForm){
  if(this.user.username&&this.user.password){
    let autorizzato= this.auth.login(this.user.username , this.user.password)
  if(autorizzato){
    form.reset()
    this.user.username=null
    this.user.password=null
this.router.navigate(['dashboard'])

  }
  }

}
}
