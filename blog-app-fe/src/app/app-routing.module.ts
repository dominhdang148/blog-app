import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainLayoutComponent } from './layout/main-layout/main-layout.component';
import { AdminLayoutComponent } from './layout/admin-layout/admin-layout.component';

const routes: Routes = [
  {
    path: '',
    component: MainLayoutComponent,
    children: [
      {
        path: '',
        loadChildren: () =>
          import('./features/public/public.module').then((m) => m.PublicModule),
      },
      {
        path: 'blog',
        loadChildren: () =>
          import('./features/client-post/client-post.module').then(
            (m) => m.ClientPostModule,
          ),
      },
      {
        path: 'not-found',
        loadChildren: () =>
          import('./features/not-found/not-found.module').then(
            (m) => m.NotFoundModule,
          ),
      },
    ],
  },
  {
    path: 'admin',
    component: AdminLayoutComponent,
  },
  {
    path: '**',
    redirectTo: 'not-found',
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
