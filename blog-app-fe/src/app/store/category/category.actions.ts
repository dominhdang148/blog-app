import { createAction, props } from '@ngrx/store';
import { CategoryItem } from 'src/app/core/model/category/category-item';

export const loadShownOnMenuCategories = createAction(
  '[Category] Load Categories Shown On Menu',
);

export const loadCategoriesSuccess = createAction(
  '[Category] Load Categories Success',
  props<{ categories: CategoryItem[] }>(),
);

export const loadCategoriesFailure = createAction(
  '[Category] Load Categories Failure',
  props<{ error: string }>(),
);
