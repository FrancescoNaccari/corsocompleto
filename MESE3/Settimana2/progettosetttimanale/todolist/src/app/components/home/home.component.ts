import { Component, OnInit } from '@angular/core';
import { Todo } from 'src/app/interfaces/todo.interface';
import { User } from 'src/app/interfaces/user.interface';
import { TodoService } from 'src/app/services/todo.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  todos!: Todo[]
  users!: User[]
  
  constructor(private todosrv: TodoService, private usersSrv: UserService) { }

  ngOnInit(): void {
    this.todosrv.tNews.subscribe((value) => {
      this.todos = value
    })
    
    this.loadUsers()
   
  }
  loadUsers() {
    this.usersSrv.getUsers().subscribe(users => {
      this.users = users
      this.usersSrv.setUsers(this.users)
    })

  }
  checks(todo: Todo) {
    this.todosrv.toggle(todo.id);
  }

  getName(userId: number): string {
    return this.usersSrv.getName(userId);
  }
}



