import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { FavoritiComponent } from './components/favoriti/favoriti.component';
import { CarrelloComponent } from './components/carrello/carrello.component';

import { NavbarComponent } from './components/navbar/navbar.component';
import { Route,RouterModule } from '@angular/router';
import { ErrorComponent } from './components/error/error.component';

const routers: Route[]=[
  {
    path:'',
    component: HomeComponent
  },
  {
    path:'favoriti',
    component: FavoritiComponent
  } ,
   {
    path:'error',
    component: ErrorComponent
  },
  {
    path:'**',
    redirectTo:'error'
  }


]

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    FavoritiComponent,
    CarrelloComponent,
 
    NavbarComponent,
    ErrorComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(routers)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
