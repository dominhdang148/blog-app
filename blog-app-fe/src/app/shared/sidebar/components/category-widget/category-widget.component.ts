import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { CategoryItem } from 'src/app/core/model/category/category-item';
import { loadShownOnMenuCategories } from 'src/app/store/category/category.actions';
import {
  selectCategoryError,
  selectCategoryLoading,
  selectShowOnMenuCategories,
} from 'src/app/store/category/category.selector';

@Component({
  selector: 'app-category-widget',
  templateUrl: './category-widget.component.html',
  styleUrls: ['./category-widget.component.css'],
})
export class CategoryWidgetComponent implements OnInit {
  categories$: Observable<CategoryItem[]>;
  loading$: Observable<boolean>;
  error$: Observable<string | null>;
  constructor(private store: Store) {
    this.categories$ = this.store.select(selectShowOnMenuCategories);
    this.loading$ = this.store.select(selectCategoryLoading);
    this.error$ = this.store.select(selectCategoryError);
  }
  ngOnInit(): void {
    this.store.dispatch(loadShownOnMenuCategories());
  }
}
