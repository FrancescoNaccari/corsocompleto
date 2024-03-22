import { Component } from '@angular/core';
import { Post } from 'src/app/models/post.interface';

@Component({
  selector: 'app-ford',
  templateUrl: './ford.component.html',
  styleUrls: ['./ford.component.scss']
})
export class FordComponent {
  posts!: Post[];

  constructor() {
    this.getPosts().then((data) => {
      this.posts = data.filter((value) => value.brand=='Ford')

    })
  }

  async getPosts() {
    let query = await fetch('assets/db.json')
    let response: Post[] = await query.json()
    return response
  }
}
