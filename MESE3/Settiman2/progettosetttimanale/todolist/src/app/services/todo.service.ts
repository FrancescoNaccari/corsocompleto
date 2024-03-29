import { Injectable, OnInit } from '@angular/core';
import { Todo } from '../interfaces/todo.interface';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, Subject, map } from 'rxjs';
import { User } from '../interfaces/user.interface';
import { UserService } from './user.service';
@Injectable({
  providedIn: 'root'
})
export class TodoService {
  url = 'assets/todo.json'
  todos: Todo[] = []
  users: User[] = []
  todNew: Todo[] = []
  tNews: BehaviorSubject<Todo[]> = new BehaviorSubject <Todo[]>([])
  constructor(private http: HttpClient, private usersSrv: UserService) {
    let fetch: any = [] //risultato fetch
    this.todNew = fetch;
    this.tNews.next(this.todNew)
  }

  getTodo(): Observable<Todo[]> {
    return this.http.get<Todo[]>(this.url)

  }

  setTodo(value:Todo[]) {
    this.todNew = value;
    this.tNews.next(this.todNew)
  }

  toggle(id: number) {
    this.todNew.forEach(element => {
      if (element.id == id) {
        element.completed = !element.completed;
      }
    })
    this.tNews.next(this.todNew)
  }


  getCompleteto() {
    return this.todNew.filter(todo => todo.completed === true)
  }

  getInCompleteto() {
    return this.todNew.filter(todo => todo.completed === false)
  }

  getName(id: number) {
    let name = ''
    for (let i = 0; i < this.users.length; i++) {
      if (this.users[i].id == id) {
        name = `${this.users[i].firstName} ${this.users[i].lastName}`

      }
    }
    return name
  }

  getTodosByUserId(userId: number): Observable<Todo[]> {
    return this.getTodo().pipe(
      map(todos => todos.filter(todo => todo.userId === userId))
    );
  }


}
