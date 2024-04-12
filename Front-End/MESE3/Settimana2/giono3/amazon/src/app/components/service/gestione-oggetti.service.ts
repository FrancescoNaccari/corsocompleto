import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Oggetti } from 'src/app/interfaces/oggetti.interface';
import { catchError, map, throwError } from 'rxjs';
import { OggettiRultato } from 'src/app/interfaces/oggetti-rultato.interface';


@Injectable({
  providedIn: 'root'
})

export class GestioneOggettiService {
  api = 'https://dummyjson.com/products'
  constructor(private http: HttpClient) { }

  getOggetto() {
    return this.http.get<OggettiRultato>(this.api).pipe(catchError((err) => {
      return throwError(this.getErrorMessage(err.status));
    })
    );
  }




  // getOggetto() {
  //   return this.http.get<Oggetti[]>(this.api).pipe(catchError((err) => {
  //     return throwError(this.getErrorMessage(err.status));
  //   })
  //   );
  // }





  
    getErrorMessage(status: number) {
        let message = '';
        switch (status) {
            case 404:
                message = 'Elementi non trovati';
                break;

            default:
                message = 'Qualcosa non ha funzionato nella chiamata';
                break;
        }
        return message;
    }
}
