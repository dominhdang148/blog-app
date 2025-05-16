import { createFeatureSelector, createSelector } from '@ngrx/store';
import { CategoryState } from './category.state';

export const selectCategoryState =
  createFeatureSelector<CategoryState>('categories');

export const selectShowOnMenuCategories = createSelector(
  selectCategoryState,
  (state) => state.categories
);

export const selectCategoryLoading = createSelector(
  selectCategoryState,
  (state) => state.loading
);

export const selectCategoryError = createSelector(
  selectCategoryState,
  (state) => state.error
);
