import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ClientPostRoutingModule } from './client-post-routing.module';
import { PostByCategoryComponent } from './pages/post-by-category/post-by-category.component';
import { SharedModule } from 'src/app/shared/shared.module';

@NgModule({
  declarations: [PostByCategoryComponent],
  imports: [CommonModule, SharedModule, ClientPostRoutingModule],
})
export class ClientPostModule {}
