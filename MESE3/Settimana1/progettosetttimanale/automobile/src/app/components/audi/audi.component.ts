import { Component } from '@angular/core';
import { Post } from 'src/app/models/post.interface';

@Component({
  selector: 'app-audi',
  templateUrl: './audi.component.html',
  styleUrls: ['./audi.component.scss']
})
export class AudiComponent {
  posts!: Post[];

  constructor() {
    this.getPosts().then((data) => {
      this.posts = data.filter((value) => value.brand == 'Audi')

    })
  }

  async getPosts() {
    let query = await fetch('assets/db.json')
    let response: Post[] = await query.json()
    return response
  }
}
