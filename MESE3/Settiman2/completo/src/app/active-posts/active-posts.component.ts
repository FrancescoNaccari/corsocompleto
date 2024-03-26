import { Component, OnInit } from '@angular/core';
import { PostInterface } from 'src/interfaces/post.interface'
import { GestionePostService } from '../services/gestione-post.service';

@Component({
  selector: 'app-active-posts',
  templateUrl: './active-posts.component.html',
  styleUrls: ['./active-posts.component.scss'],
})
export class ActivePostsComponent implements OnInit{

  constructor(private gestionePost: GestionePostService) {}
  
posts:PostInterface[]=[]
ngOnInit(): void {
  
   this.posts=this.gestionePost.getPosts().filter((post) => post.active);
     
  }
}


  
