import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainLayoutComponent } from './layout/main-layout/main-layout.component';
import { SharedModule } from './shared/shared.module';
import { AdminLayoutComponent } from './layout/admin-layout/admin-layout.component';

@NgModule({
  declarations: [AppComponent, MainLayoutComponent, AdminLayoutComponent],
  imports: [BrowserModule, AppRoutingModule, SharedModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
