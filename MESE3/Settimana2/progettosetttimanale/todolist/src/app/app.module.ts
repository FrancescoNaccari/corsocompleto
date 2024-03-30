import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterOutlet, Route, Router, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CompletatiComponent } from './components/completati/completati.component';
import { IncompletiComponent } from './components/incompleti/incompleti.component';
import { UtentiComponent } from './components/utenti/utenti.component';
import { Error404Component } from './components/error404/error404.component';

import { HttpClientModule } from '@angular/common/http'

const routes:Route[]=[
  {
    path:'',
    component:HomeComponent
  },
  {
    path:'completati',
    component:CompletatiComponent
  },
  {
    path:'incompleti',
    component:IncompletiComponent
  },
  {
    path:'utenti',
    component:UtentiComponent
  },
  {
    path:'**',
    component:Error404Component
  }
  
  
  
  
]

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    CompletatiComponent,
    IncompletiComponent,
    UtentiComponent,
    Error404Component
  ],
  imports: [
    BrowserModule,
    NgbModule,
    RouterModule.forRoot(routes),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
