import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeComponent } from './pages/home/home.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { PublicRoutingModule } from './public-routing.module';
import { AboutComponent } from './pages/about/about.component';
import { ContactComponent } from './pages/contact/contact.component';

@NgModule({
  declarations: [HomeComponent, AboutComponent, ContactComponent],
  imports: [CommonModule, PublicRoutingModule, SharedModule],
})
export class PublicModule {}
