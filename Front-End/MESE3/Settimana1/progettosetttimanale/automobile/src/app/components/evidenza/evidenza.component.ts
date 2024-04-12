import { Component } from '@angular/core';
import { Car } from 'src/app/models/car.interface';

@Component({
  selector: 'app-evidenza',
  templateUrl: './evidenza.component.html',
  styleUrls: ['./evidenza.component.scss']
})
export class EvidenzaComponent {
  cars: Car[] = [];
  related: Car[] = []
  included: number[] = []
  isLoaded = false

  constructor() {
    this.getCar()

  };

  async getCar() {
    let response = await fetch('assets/db.json')
    let data = await response.json()
    this.cars = data
    this.correlatiCars()
    
  }

  correlatiCars() {
    for (let i = 0; i < 2; i++) {
      let index = Math.floor(Math.random() * this.cars.length);
      if (this.included.includes(index)) {
        index = Math.floor(Math.random() * this.cars.length)
      }
      this.included.push(index)
    }
    for (let i = 0; i < this.included.length; i++) {
      let carsIndex = this.included[i] ;
      this.related.push(this.cars[carsIndex])
    }
    this.isLoaded = true
  }
}
