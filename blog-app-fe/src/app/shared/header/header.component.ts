import { Component } from '@angular/core';
import { MenuItem } from 'src/app/core/model/menu-item';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent {
  menuItems: MenuItem[] = [
    {
      id: 1,
      title: 'Home',
      path: '/home',
    },
    {
      id: 2,
      title: 'About',
      path: '/about',
    },
    {
      id: 3,
      title: 'Contact',
      path: '/contact',
    },
  ];
}
