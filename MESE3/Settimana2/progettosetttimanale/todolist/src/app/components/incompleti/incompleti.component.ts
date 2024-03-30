import { Component, OnInit } from '@angular/core';
import { Todo } from 'src/app/interfaces/todo.interface';
import { TodoService } from 'src/app/services/todo.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-incompleti',
  templateUrl: './incompleti.component.html',
  styleUrls: ['./incompleti.component.scss']
})

export class IncompletiComponent implements OnInit {
  incompleTodo: Todo[] = []
  constructor(private incompletatiSrv: TodoService, private usersSrc: UserService) { }

  ngOnInit(): void {
    this.incompletatiSrv.tNews.subscribe((value) => {
      this.incompleTodo = value.filter(elemenet => !elemenet.completed)
    })
  }

  getName(userId: number): string {
    return this.usersSrc.getName(userId);
  }

  checks(todo: Todo) {
    this.incompletatiSrv.toggle(todo.id);
  }
}
