import { Component, OnInit } from '@angular/core';
import { Todo } from 'src/app/interfaces/todo.interface';
import { TodoService } from 'src/app/services/todo.service';

@Component({
  selector: 'app-completati',
  templateUrl: './completati.component.html',
  styleUrls: ['./completati.component.scss']
})
export class CompletatiComponent implements OnInit {
  compleTodo: Todo[] = []
  constructor(private completatiSrv: TodoService, private todosrv: TodoService) { }

  ngOnInit(): void {
    this.todosrv.tNews.subscribe((value) => {
      this.compleTodo = value.filter(elemenet => elemenet.completed)
    })
  }

  getName(userId: number): string {
    return this.todosrv.getName(userId);
  }

  checks(todo: Todo) {
    this.todosrv.toggle(todo.id);
  }
}

