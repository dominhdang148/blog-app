import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { PostListComponent } from './post-list/post-list.component';
import { PostItemComponent } from './post-list/components/post-item/post-item.component';
import { TagListComponent } from './post-list/components/tag-list/tag-list.component';
import { PaginationComponent } from './pagination/pagination.component';

@NgModule({
  declarations: [
    HeaderComponent,
    SidebarComponent,
    PostListComponent,
    PostItemComponent,
    TagListComponent,
    PaginationComponent,
  ],
  imports: [CommonModule],
  exports: [
    HeaderComponent,
    SidebarComponent,
    PostListComponent,
    PaginationComponent,
  ],
})
export class SharedModule {}
