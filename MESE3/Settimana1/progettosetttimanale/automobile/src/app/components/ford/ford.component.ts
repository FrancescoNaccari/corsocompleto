import { Component } from '@angular/core';
import { Car } from 'src/app/models/car.interface';

@Component({
  selector: 'app-ford',
  templateUrl: './ford.component.html',
  styleUrls: ['./ford.component.scss']
})
export class FordComponent {
  cars!: Car[];

  constructor() {
    this.getCars().then((data) => {
      this.cars = data.filter((value) => value.brand=='Ford')

    })
  }

  async getCars() {
    let query = await fetch('assets/db.json')
    let response: Car[] = await query.json()
    return response
  }
}
