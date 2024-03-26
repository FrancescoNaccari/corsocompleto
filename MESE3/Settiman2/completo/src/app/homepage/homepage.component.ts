import { Component, OnInit, ViewChild } from '@angular/core';
import { PostInterface } from 'src/interfaces/post.interface';
import { SinglePostComponent } from '../single-post/single-post.component';
import { GestionePostService } from '../services/gestione-post.service';


@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.scss'],
})
export class HomepageComponent implements OnInit {
  post!: PostInterface
  related: PostInterface[] = [];
  posts: PostInterface[] = [];
filtroTag:string='all'
  alltags: string[] = [];

  @ViewChild("singlePost") singlePost!: SinglePostComponent

  constructor(private pippo: GestionePostService) {

  }

  ngOnInit(): void {
    this.posts = this.pippo.getPosts()
    console.log(this.posts)
    this.post = this.topPost
    this.related = this.getRandomPosts(4)

    this.posts.forEach(element => {
      for (let i = 0; i < element.tags.length; i++) {
        if (!this.alltags.includes(element.tags[i])) {
          this.alltags.push(element.tags[i])
        }

      }

    })
  }

filtro(tag:string){
  this.filtroTag=tag
  let tags=document.querySelectorAll('#filtro span')
tags.forEach(element=>{
  if(element.classList.contains('text-bg-primary')){
    element.classList.remove('text-bg-primary')
    element.classList.add('text-bg-secondary')
  }
  if(element.innerHTML==tag.toUpperCase()){
    element.classList.add('text-bg-primary')
    element.classList.remove('text-bg-secondary')
  }
})

}


  get topPost(): PostInterface {
    return this.posts.sort((a, b) => b.reactions - a.reactions)[0];
  }
  getRandomPosts(num: number): PostInterface[] {
    const randomPosts: PostInterface[] = [];
    const numHistory: number[] = [];
    for (let i = 0; i < num; i++) {
      const random = Math.floor(Math.random() * this.posts.length);
      if (numHistory.includes(random)) continue;
      numHistory.push(random);
      randomPosts.push(this.posts[random]);
    }
    return randomPosts;
  }
  editPost() {
    alert("Edit successful!")
  }
}
