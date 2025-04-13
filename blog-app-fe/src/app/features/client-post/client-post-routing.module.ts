import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PostByCategoryComponent } from './pages/post-by-category/post-by-category.component';
import { PostByAuthorComponent } from './pages/post-by-author/post-by-author.component';

const routes: Routes = [
  {
    path: 'category/:slug',
    component: PostByCategoryComponent,
  },
  {
    path: 'author/:slug',
    component: PostByAuthorComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ClientPostRoutingModule {}
