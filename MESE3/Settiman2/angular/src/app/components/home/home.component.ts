import { Component,OnInit } from '@angular/core';
import { Post } from 'src/app/models/post.interface';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  posts: Post[] = [];
 

  constructor() {
    

  };
  
  ngOnInit() {
    this.getPost();
  }

  async getPost() {
    let response = await fetch('assets/db.json')
    let data = await response.json()
    this.posts = data
}}
