import { Component, ElementRef, OnDestroy, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { Subscription } from 'rxjs';
import { SocialAuthService } from '@abacritt/angularx-social-login';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss'],
})

export class LoginComponent {
    constructor(private authSrv: AuthService, private router: Router) {}

    login(form: NgForm) {
        console.log(form.value);
        try {
            this.authSrv.login(form.value).subscribe();
            this.router.navigate(['/']);
        } catch (error) {
            console.error(error);
        }
    }


    onSubmit(form: NgForm) {
        console.log(form.value);
        try {
            this.authSrv.signup(form.value).subscribe();
            this.router.navigate(['/login']);
        } catch (error) {
            console.error(error);
        }
    }

    @ViewChild('container') container!: ElementRef;

    signIn() {
        this.container.nativeElement.classList.remove('right-panel-active');
    }

    signUp() {
        this.container.nativeElement.classList.add('right-panel-active');
    }


    authSubscription!: Subscription;

    googleSignin(googleWrapper: any) {
        googleWrapper.click();
    }




}
