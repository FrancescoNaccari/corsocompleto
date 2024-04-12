import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Register } from '../interface/register.interface';
import { environment } from 'src/environments/environment.development';
import { BehaviorSubject, throwError } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';
import { Router } from '@angular/router';
import { AuthData } from '../interface/auth-data.interface';
import { JwtHelperService } from '@auth0/angular-jwt';
import { SocialAuthService, SocialUser } from '@abacritt/angularx-social-login';

@Injectable({
    providedIn: 'root',
})
export class AuthService {
    apiURL = environment.apiURL;
    jwtHelper = new JwtHelperService();

    // elementi per gestire la procedura di login
    private authSub = new BehaviorSubject<AuthData | null | SocialUser>(null);
    user$ = this.authSub.asObservable();
    

    constructor(private http: HttpClient, private router: Router, private authService: SocialAuthService) {
        this.authService.authState.subscribe((user) => {
            this.authSub.next(user);
            localStorage.setItem('user', JSON.stringify(user));
            this.router.navigate(['/']);
        });
    }

    login(data: { email: string; password: string }) {
        return this.http.post<AuthData>(`${this.apiURL}login`, data).pipe(
            tap((data) => {
                console.log('Auth data: ', data);
            }),
            tap((data) => {
                this.authSub.next(data);
                localStorage.setItem('user', JSON.stringify(data));
            }),
            catchError(this.errors)
        );
    }

    signup(data: Register) {
        return this.http
            .post(`${this.apiURL}register`, data)
            .pipe(catchError(this.errors));
    }

    logout() {
        this.authSub.next(null);
        localStorage.removeItem('user');
        this.router.navigate(['/login']);
    }

    restore() {
        const userJson = localStorage.getItem('user');
        if (!userJson) {
            return;
        }
        const user: AuthData = JSON.parse(userJson);
        this.authSub.next(user);
    }
    private errors(err: any) {
      console.log(err.error);
      switch (err.error) {
          case 'Email already exists':
              return throwError('utente già presente');
              break;

          case 'Incorrect password':
              return throwError('password errata');
              break;

          case 'Cannot find user':
              return throwError('Utente non trovato');
              break;

          default:
              return throwError('Errore nella chiamata');
              break;
      }
  }
  }