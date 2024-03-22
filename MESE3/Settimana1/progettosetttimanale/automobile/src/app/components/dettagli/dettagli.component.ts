import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { Post } from 'src/app/models/post.interface';

@Component({
  selector: 'app-dettagli',
  templateUrl: './dettagli.component.html',
  styleUrls: ['./dettagli.component.scss']
})
export class DettagliComponent implements OnInit {
  postId!: string;
  post!: Post;
private sub!:Subscription
  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.sub=this.route.params.subscribe(params => {
      this.postId = params['id'];
  this.getpost()
      
      
    });
  
  }   
  
  async getpost() {
        let response = await fetch('assets/db.json')
        let data:Post[]= await response.json()
      
        let post=data.find((element)=>element.model==this.postId)
        if (post){
          this.post=post
        }
        
      }
}