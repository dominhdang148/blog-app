import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ClientPostRoutingModule } from './client-post-routing.module';
import { PostByCategoryComponent } from './pages/post-by-category/post-by-category.component';

@NgModule({
  declarations: [PostByCategoryComponent],
  imports: [CommonModule, ClientPostRoutingModule],
})
export class ClientPostModule {}
