import { Component } from '@angular/core';
import { Post } from 'src/app/models/post.interface';

@Component({
  selector: 'app-consigliati',
  templateUrl: './consigliati.component.html',
  styleUrls: ['./consigliati.component.scss']
})
export class ConsigliatiComponent {


  posts: Post[] = [];
  consigliati: Post[] = []
  included: number[] = []
  isLoaded=false 

  constructor() {
    this.getpost()

  };

  async getpost() {
    let response = await fetch('assets/db.json')
    let data = await response.json()
    this.posts = data

    this.correlatiPosts()
    this.consigliatiPosts()
    this.isLoaded=true
  }

  correlatiPosts() {
    for (let i = 0; i < 4; i++) {
      let index = Math.floor(Math.random() * this.posts.length);
      if (this.included.includes(index)) {
        index = Math.floor(Math.random() * this.posts.length)
      }
      this.included.push(index)
    }

  }
  consigliatiPosts() {
    for (let i = 0; i < this.included.length; i++) {
      let postsIndex = this.included[i] - 1;
      this.consigliati.push(this.posts[postsIndex])
    }
  }
}


