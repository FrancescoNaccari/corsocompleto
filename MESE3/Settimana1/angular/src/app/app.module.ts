import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';


import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { ActivePostsComponent } from './components/active-posts/active-posts.component';
import { IncactivePostsComponent } from './components/incactive-posts/incactive-posts.component';
import { PostsDetailComponent } from './components/posts-detail/posts-detail.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { EvidenzaComponent } from './components/evidenza/evidenza.component';
import { CorrelatiComponent } from './components/correlati/correlati.component';
import { ConsigliatiComponent } from './components/consigliati/consigliati.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ActivePostsComponent,
    IncactivePostsComponent,
    PostsDetailComponent,
    NavbarComponent,
    EvidenzaComponent,
    CorrelatiComponent,
    ConsigliatiComponent


  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
