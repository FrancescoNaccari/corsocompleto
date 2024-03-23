import { Component } from '@angular/core';
import { Post } from 'src/app/models/post.interface'; 

@Component({
  selector: 'app-anteprima',
  templateUrl: './anteprima.component.html',
  styleUrls: ['./anteprima.component.scss']
})
export class AnteprimaComponent {

  post!: Post[];
  loghi:Post[]=[];

    constructor() {
      this.getpost()
      
      };
    
    async getpost() {
      const response = await fetch('assets/db.json')
      const data = await response.json()
      this.post= data;
    
      
 
    }
  
}
