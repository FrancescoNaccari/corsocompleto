import { Directive, ElementRef } from '@angular/core';

@Directive({
  selector: '[appColorRandom]'
})
export class ColorRandomDirective {

  constructor(private element:ElementRef) {
this.element.nativeElement.style.backgroundColor=this.getRandomColor()

   }

   private getRandomColor(): string {
    const letters = '0123456789ABCDEF';
    let color = '#';
    for (let i = 0; i < 6; i++) {
      color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
  }
}
