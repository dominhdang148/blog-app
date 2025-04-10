import { NgModule, effect } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainLayoutComponent } from './layout/main-layout/main-layout.component';
import { SharedModule } from './shared/shared.module';
import { AdminLayoutComponent } from './layout/admin-layout/admin-layout.component';
import { HttpClientModule } from '@angular/common/http';
import { StoreModule } from '@ngrx/store';
import { postReducer } from './store/post/post.reducer';
import { EffectsModule } from '@ngrx/effects';
import { PostEffects } from './store/post/post.effects';
import { categoryReducer } from './store/category/category.reducer';
import { appReducer } from './store/app.reducer';
import { CategoryEffects } from './store/category/category.effects';
@NgModule({
  declarations: [AppComponent, MainLayoutComponent, AdminLayoutComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SharedModule,
    HttpClientModule,
    StoreModule.forRoot(appReducer),
    StoreModule.forFeature('posts', postReducer),
    StoreModule.forFeature('categories', categoryReducer),
    EffectsModule.forRoot([PostEffects, CategoryEffects]),
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
