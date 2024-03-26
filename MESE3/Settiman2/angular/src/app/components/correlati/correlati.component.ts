import { Component } from '@angular/core';
import { Post } from 'src/app/models/post.interface';

@Component({
  selector: 'app-correlati',
  templateUrl: './correlati.component.html',
  styleUrls: ['./correlati.component.scss']
})
export class CorrelatiComponent {

  posts: Post[] = [];
  related: Post[] = []
  included: number[] = []
  isLoaded = false

  constructor() {
    this.getpost()

  };

  async getpost() {
    let response = await fetch('assets/db.json')
    let data = await response.json()
    this.posts = data
    this.correlatiPosts()
    
  }

  correlatiPosts() {
    for (let i = 0; i < 2; i++) {
      let index = Math.floor(Math.random() * this.posts.length);
      if (this.included.includes(index)) {
        index = Math.floor(Math.random() * this.posts.length)
      }
      this.included.push(index)
    }
    for (let i = 0; i < this.included.length; i++) {
      let postsIndex = this.included[i] ;
      this.related.push(this.posts[postsIndex])
    }
    this.isLoaded = true
  }

}
