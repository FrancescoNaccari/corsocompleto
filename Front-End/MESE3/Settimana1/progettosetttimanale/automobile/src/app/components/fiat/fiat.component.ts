import { Component } from '@angular/core';
import { Car } from 'src/app/models/car.interface';

@Component({
  selector: 'app-fiat',
  templateUrl: './fiat.component.html',
  styleUrls: ['./fiat.component.scss']
})
export class FiatComponent {
  cars!: Car[];

  constructor() {
    this.getCars().then((data) => {
      this.cars = data.filter((value) => value.brand == 'Fiat')

    })
  }

  async getCars() {
    let query = await fetch('assets/db.json')
    let response: Car[] = await query.json()
    return response
  }
}
