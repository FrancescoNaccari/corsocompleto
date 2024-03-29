import { Component, OnInit } from '@angular/core';
import { Todo } from 'src/app/interfaces/todo.interface';
import { User } from 'src/app/interfaces/user.interface';
import { TodoService } from 'src/app/services/todo.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-utenti',
  templateUrl: './utenti.component.html',
  styleUrls: ['./utenti.component.scss']
})
export class UtentiComponent implements OnInit {
  users: User[] = [];
  userTodosMap: Map<number, Todo[]> = new Map();
todo: any;

  constructor(private userSrv: UserService, private todoSrv: TodoService) { }

  ngOnInit(): void {
    this.loadUsers()
  }

  loadUsers() {
    this.userSrv.getUsers().subscribe(users => {
      this.users = users;
      this.loadUserTodos();
    });
  }
  loadUserTodos(): void {
    this.users.forEach(user => {
      this.todoSrv.getTodosByUserId(user.id).subscribe(todos => {
        this.userTodosMap.set(user.id, todos);
      });
    });
  }
}