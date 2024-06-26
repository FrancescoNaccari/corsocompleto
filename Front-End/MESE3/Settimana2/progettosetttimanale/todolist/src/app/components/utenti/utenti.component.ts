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
  todo:Todo[]=[];

  constructor(private userSrv: UserService, private todoSrv: TodoService) { }

  ngOnInit(): void {
    this.todoSrv.tNews.subscribe((value) => {
     
      this.todo = value
     this.loadUsers()
    })
   
  }

  loadUsers() {
    this.userSrv.getUsers().subscribe(users => {
      this.users = users;
      this.userSrv.setUsers(this.users)
      this.loadUserTodos();
    });
  }
  loadUserTodos(): void {
    this.users.forEach(user => {
      let filter=this.todo.filter(element=>element.userId==user.id)
        this.userTodosMap.set(user.id, filter);
  
    });
  }
  checks(todo: Todo) {
    
    this.todoSrv.toggle(todo.id);

  }

  
}