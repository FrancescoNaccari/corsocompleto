import { Component, OnInit } from '@angular/core';
import { PostInterface } from 'src/interfaces/post.interface';
import { GestionePostService } from '../services/gestione-post.service';

@Component({
  selector: 'app-inactive-posts',
  templateUrl: './inactive-posts.component.html',
  styleUrls: ['./inactive-posts.component.scss']
})
export class InactivePostsComponent implements OnInit {
  posts: PostInterface[] = [];

  constructor(private gestionePost: GestionePostService) { }

  ngOnInit(): void {
    this.posts = this.gestionePost.getPosts().filter((post)=> !post.active)
  }


  
}
