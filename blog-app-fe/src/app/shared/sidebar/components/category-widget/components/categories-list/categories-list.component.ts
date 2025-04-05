import { Component, Input } from '@angular/core';
import { CategoryItem } from 'src/app/core/model/category/category-item';

@Component({
  selector: 'app-categories-list',
  templateUrl: './categories-list.component.html',
  styleUrls: ['./categories-list.component.css'],
})
export class CategoriesListComponent {
  @Input() categories!: CategoryItem[] | null;
  @Input() loading!: boolean | null;
}
