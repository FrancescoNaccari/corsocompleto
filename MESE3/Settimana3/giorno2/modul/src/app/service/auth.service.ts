import { Injectable } from '@angular/core';
import { User } from '../interface/user.interface';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  user: User={
    username:null,
    password:null
  };
  isLoggendIn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>( false)
  constructor() { }

  login(username: string, password: string) {
    this.user.username = username
    this.user.password = password
    this.isLoggendIn.next(true)
    return true
  }
  logout() {
    this.user.username = null
    this.user.password = null
    this.isLoggendIn.next(false)
    return true
  }


}
