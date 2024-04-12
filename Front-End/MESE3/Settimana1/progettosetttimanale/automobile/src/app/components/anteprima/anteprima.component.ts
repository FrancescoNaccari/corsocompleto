import { Component } from '@angular/core';
import { Car } from 'src/app/models/car.interface'; 

@Component({
  selector: 'app-anteprima',
  templateUrl: './anteprima.component.html',
  styleUrls: ['./anteprima.component.scss']
})
export class AnteprimaComponent {

  car!: Car[];
  loghi:Car[]=[];

    constructor() {
      this.getCar()
      
      };
    
    async getCar() {
      const response = await fetch('assets/db.json')
      const data = await response.json()
      this.car= data;
    
      
 
    }
  
}
