import { Component } from '@angular/core';
import { Car } from 'src/app/models/car.interface';

@Component({
  selector: 'app-audi',
  templateUrl: './audi.component.html',
  styleUrls: ['./audi.component.scss']
})
export class AudiComponent {
  cars!: Car[];

  constructor() {
    this.getCars().then((data) => {
      this.cars = data.filter((value) => value.brand == 'Audi')

    })
  }

  async getCars() {
    let query = await fetch('assets/db.json')
    let response: Car[] = await query.json()
    return response
  }
}
