import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ClientPostRoutingModule } from './client-post-routing.module';
import { PostByCategoryComponent } from './pages/post-by-category/post-by-category.component';
import { SharedModule } from 'src/app/shared/shared.module';
import { PostByAuthorComponent } from './pages/post-by-author/post-by-author.component';
import { PostByTagComponent } from './pages/post-by-tag/post-by-tag.component';
import { PostDetailComponent } from './pages/post-detail/post-detail.component';

@NgModule({
  declarations: [
    PostByCategoryComponent,
    PostByAuthorComponent,
    PostByTagComponent,
    PostDetailComponent,
  ],
  imports: [CommonModule, SharedModule, ClientPostRoutingModule],
})
export class ClientPostModule {}
