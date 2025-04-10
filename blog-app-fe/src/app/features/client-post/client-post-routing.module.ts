import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PostByCategoryComponent } from './pages/post-by-category/post-by-category.component';

const routes: Routes = [
  {
    path: 'category/:slug',
    component: PostByCategoryComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ClientPostRoutingModule {}
