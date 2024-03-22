import { Component } from '@angular/core';
import { Post } from 'src/app/models/post.interface';

@Component({
  selector: 'app-fiat',
  templateUrl: './fiat.component.html',
  styleUrls: ['./fiat.component.scss']
})
export class FiatComponent {
  posts!: Post[];

  constructor() {
    this.getPosts().then((data) => {
      this.posts = data.filter((value) => value.brand == 'Fiat')

    })
  }

  async getPosts() {
    let query = await fetch('assets/db.json')
    let response: Post[] = await query.json()
    return response
  }
}
