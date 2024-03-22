import { Component } from '@angular/core';
import { Post } from 'src/app/models/post.interface'; 

@Component({
  selector: 'app-marchi',
  templateUrl: './marchi.component.html',
  styleUrls: ['./marchi.component.scss']
})
export class MarchiComponent {
  post!: Post[];
  loghi:Post[]=[];

    constructor() {
      this.getpost()
      
      };
    
    async getpost() {
      const response = await fetch('assets/db.json')
      const data = await response.json()
      this.post= data;
     this.loghi=this.post.slice(0, 3)
      
 
    }
  

}
