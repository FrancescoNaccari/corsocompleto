import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { User } from '../interfaces/user.interface';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  users: User[] = []
  url = 'assets/users.json'
  constructor(private http: HttpClient) { }
  getUsers() {
    return this.http.get<User[]>(this.url)

  }

  setUsers(users:User[]) {
      this.users = users
  }

  getName(id:number) {
    let name = ''
    for (let i = 0; i < this.users.length; i++) {
      if (this.users[i].id == id) {
        name = `${this.users[i].firstName} ${this.users[i].lastName}`

      }
    }
    return name
  }
}
