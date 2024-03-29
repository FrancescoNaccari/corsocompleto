import { Injectable, OnInit } from '@angular/core';
import { Todo } from '../interfaces/todo.interface';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class TodoService implements OnInit {
  url = 'assets/todo.json'
  constructor(private http: HttpClient) { }
  ngOnInit(): void {
    this.getTodo()
  }
  getTodo() {
    return this.http.get<Todo[]>(this.url)

  }

}
