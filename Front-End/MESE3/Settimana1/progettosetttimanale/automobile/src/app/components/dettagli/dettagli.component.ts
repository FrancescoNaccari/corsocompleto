import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { Car } from 'src/app/models/car.interface';

@Component({
  selector: 'app-dettagli',
  templateUrl: './dettagli.component.html',
  styleUrls: ['./dettagli.component.scss']
})
export class DettagliComponent implements OnInit {
  carId!: string;
  car!: Car;
private sub!:Subscription
  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.sub=this.route.params.subscribe(params => {
      this.carId = params['id'];
  this.getCar()
      
      
    });
  
  }   
  
  async getCar() {
        let response = await fetch('assets/db.json')
        let data:Car[]= await response.json()
      
        let car=data.find((element)=>element.model==this.carId)
        if (car){
          this.car=car
        }
        
      }
}