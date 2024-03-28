import { Component, OnDestroy, OnInit } from '@angular/core';
import { GestioneOggettiService } from '../service/gestione-oggetti.service';
import { Subscription } from 'rxjs';
import { Oggetti } from 'src/app/interfaces/oggetti.interface';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit,OnDestroy {
  sub!: Subscription
  articolo: Oggetti[]=[]
  constructor(private oggettoSrv: GestioneOggettiService) { }

  ngOnInit(): void {
    this.caricaOggetto()
  }

  caricaOggetto() {
    this.sub = this.oggettoSrv.getOggetto().subscribe(
      (risult) => {
        if (Array.isArray(risult.products)) {
          this.articolo = risult.products;
        } else {
          console.error('Il risultato non è un array:', risult);
        }
      },
      (err) => {
        console.error('Errore durante il caricamento degli oggetti:', err);
      }
    );
  }


  ngOnDestroy(): void {
  this.sub.unsubscribe()
}
}
