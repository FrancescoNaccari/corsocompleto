import { Component } from '@angular/core';
import { Post } from 'src/app/models/post.interface';

@Component({
  selector: 'app-active-posts',
  templateUrl: './active-posts.component.html',
  styleUrls: ['./active-posts.component.scss']
})
export class ActivePostsComponent {
  posts!: Post[];

  constructor() {
    this.getPosts().then((data) => {
      this.posts = data.filter((value) => value.active)

    })
  }

  async getPosts() {
    let query = await fetch('assets/db.json')
    let response: Post[] = await query.json()
    return response
  }
}
