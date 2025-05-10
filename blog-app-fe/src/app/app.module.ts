import { NgModule, isDevMode } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainLayoutComponent } from './layout/main-layout/main-layout.component';
import { SharedModule } from './shared/shared.module';
import { AdminLayoutComponent } from './layout/admin-layout/admin-layout.component';
import { HttpClientModule } from '@angular/common/http';
import { StoreModule } from '@ngrx/store';
import { EffectsModule } from '@ngrx/effects';
import { categoryReducer } from './store/category/category.reducer';
import { appReducer } from './store/app.reducer';
import { CategoryEffects } from './store/category/category.effects';
import { postListReducer } from './store/post/post-list/post-list.reducer';
import { PostListEffects } from './store/post/post-list/post-list.effects';
import { postDetailReducer } from './store/post/post-detail/post-detail.reducer';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';
import { PostDetailEffects } from './store/post/post-detail/post-detail.effect';
@NgModule({
  declarations: [AppComponent, MainLayoutComponent, AdminLayoutComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SharedModule,
    HttpClientModule,
    StoreModule.forRoot(appReducer),
    StoreModule.forFeature('posts', postListReducer),
    StoreModule.forFeature('postDetail', postDetailReducer),
    StoreModule.forFeature('categories', categoryReducer),
    EffectsModule.forRoot([
      PostListEffects,
      CategoryEffects,
      PostDetailEffects,
    ]),
    StoreDevtoolsModule.instrument({ maxAge: 25, logOnly: !isDevMode() }),
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
