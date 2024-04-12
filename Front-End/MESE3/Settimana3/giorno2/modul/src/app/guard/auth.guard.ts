import { ActivatedRouteSnapshot, CanActivateFn,  Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { AuthService } from '../service/auth.service';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn:'root'
})
export class AuthGuard{
  constructor(private authService: AuthService, private router:Router){}

  canActivate(next:ActivatedRouteSnapshot, state:RouterStateSnapshot):Observable<boolean>|Promise<boolean>|UrlTree|boolean{
    if(this.authService.isLoggendIn.value!==true){
      this.router.navigate(['login'])
    }
    return true
  }
}