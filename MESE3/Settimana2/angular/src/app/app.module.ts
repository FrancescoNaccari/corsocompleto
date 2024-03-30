import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Route } from '@angular/router';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { ActivePostsComponent } from './components/active-posts/active-posts.component';
import { IncactivePostsComponent } from './components/incactive-posts/incactive-posts.component';
import { PostsDetailComponent } from './components/posts-detail/posts-detail.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { EvidenzaComponent } from './components/evidenza/evidenza.component';
import { CorrelatiComponent } from './components/correlati/correlati.component';
import { ConsigliatiComponent } from './components/consigliati/consigliati.component';
import { SinglePostComponent } from './components/single-post/single-post.component';

const routes: Route[] = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'active',
    component: ActivePostsComponent
  },
  {
    path: 'inactive',
    component: IncactivePostsComponent
  },
  {
    path: 'postDetail/:id',
    component: PostsDetailComponent
  }
]

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
    ConsigliatiComponent,
    SinglePostComponent


  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
