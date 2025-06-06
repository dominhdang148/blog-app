import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './header/header.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { PostListComponent } from './post-list/post-list.component';
import { PostItemComponent } from './post-list/components/post-item/post-item.component';
import { TagListComponent } from './post-list/components/tag-list/tag-list.component';
import { PaginationComponent } from './pagination/pagination.component';
import { PostItemPlaceholderComponent } from './post-list/components/post-item-placeholder/post-item-placeholder.component';
import { SearchFormComponent } from './sidebar/components/search-form/search-form.component';
import { FormsModule } from '@angular/forms';
import { CategoryWidgetComponent } from './sidebar/components/category-widget/category-widget.component';
import { CategoriesListComponent } from './sidebar/components/category-widget/components/categories-list/categories-list.component';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    HeaderComponent,
    SidebarComponent,
    PostListComponent,
    PostItemComponent,
    TagListComponent,
    PaginationComponent,
    PostItemPlaceholderComponent,
    SearchFormComponent,
    CategoryWidgetComponent,
    CategoriesListComponent,
  ],
  imports: [CommonModule, FormsModule, RouterModule],
  exports: [
    HeaderComponent,
    SidebarComponent,
    PostListComponent,
    PaginationComponent,
  ],
})
export class SharedModule {}
