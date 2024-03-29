import { Component } from '@angular/core';
import { Post } from 'src/app/models/post.interface';

@Component({
  selector: 'app-evidenza',
  templateUrl: './evidenza.component.html',
  styleUrls: ['./evidenza.component.scss']
})
export class EvidenzaComponent {
  post!: Post;
posts!:Post[];
isLoaded=false 

  constructor() {
    this.getpost()
    
    };
  
  async getpost() {
    const response = await fetch('assets/db.json')
    const data = await response.json()
    this.posts= data;
    let index= Math.floor(Math.random()*this.posts.length)
    this.post=this.posts[index]
    this.isLoaded=true
  }

}
