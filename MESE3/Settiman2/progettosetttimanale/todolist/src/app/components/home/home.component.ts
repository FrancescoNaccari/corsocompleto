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
  todos!:Todo[]
  users!:User[]
constructor(private todosrv:TodoService, private usersSrv:UserService){}

ngOnInit(): void {
  this.loadTodo()
  this.loadUsers()
}

loadTodo(){
this.todosrv.getTodo().subscribe(todos=>this.todos=todos)

}
loadUsers(){
  this.usersSrv.getUsers().subscribe(users=>this.users=users)
  
  }

}
