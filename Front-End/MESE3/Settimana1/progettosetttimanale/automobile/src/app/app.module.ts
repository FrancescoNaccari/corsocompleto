import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Route } from '@angular/router';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { FiatComponent } from './components/fiat/fiat.component';
import { FordComponent } from './components/ford/ford.component';
import { AudiComponent } from './components/audi/audi.component';
import { JumbotronComponent } from './components/jumbotron/jumbotron.component';
import { MarchiComponent } from './components/marchi/marchi.component';
import { EvidenzaComponent } from './components/evidenza/evidenza.component';
import { DettagliComponent } from './components/dettagli/dettagli.component';
import { AnteprimaComponent } from './components/anteprima/anteprima.component';
import { Error404Component } from './components/error404/error404.component';




const routes: Route[] = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'fiat',
    component: FiatComponent
  },
  {
    path: 'ford',
    component: FordComponent
  },
  {
    path: 'audi',
    component: AudiComponent
  },
  {
    path: 'dettagli/:id',
    component: DettagliComponent
  },
  {
    path: 'error404',
    component: Error404Component
  },
  {
    path: '**',
    redirectTo: 'error404'
  }


]

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    FooterComponent,
    FiatComponent,
    FordComponent,
    AudiComponent,
    JumbotronComponent,
    MarchiComponent,
    EvidenzaComponent,
    DettagliComponent,
    AnteprimaComponent,
    Error404Component,


  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
