import { Injectable, OnInit } from '@angular/core';
import { Todo } from '../interfaces/todo.interface';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, Subject, map } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class TodoService {
  url = 'assets/todo.json'
  todos: Todo[] = []
  todNew: Todo[] = []
  tNews: BehaviorSubject<Todo[]> = new BehaviorSubject <Todo[]>([])

  constructor(private http: HttpClient ) {
    this.getTodo().subscribe(fetch=>{
       this.todNew = fetch;
    this.tNews.next(this.todNew)
    })
   
   
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

  getTodosByUserId(userId: number): Observable<Todo[]> {
    return this.getTodo().pipe(
      map(todos => todos.filter(todo => todo.userId === userId))
    );
  }


}
