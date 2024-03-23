import { Component } from '@angular/core';
import { Car } from 'src/app/models/car.interface';

@Component({
  selector: 'app-marchi',
  templateUrl: './marchi.component.html',
  styleUrls: ['./marchi.component.scss']
})
export class MarchiComponent {
  car!: Car[];
  loghi:Car[]=[];

    constructor() {
      this.getcar()
      
      };
    
    async getcar() {
      const response = await fetch('assets/db.json')
      const data = await response.json()
      this.car= data;
     this.loghi=this.car.slice(0, 3)
      
 
    }
  

}
