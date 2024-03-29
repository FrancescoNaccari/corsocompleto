import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { User } from '../interfaces/user.interface';

@Injectable({
  providedIn: 'root'
})
export class UserService implements OnInit {

  url = 'assets/users.json'
  constructor(private http: HttpClient) { }
  ngOnInit(): void {
    this.getUsers()
  }
  getUsers() {
    return this.http.get<User[]>(this.url)

  }

}
