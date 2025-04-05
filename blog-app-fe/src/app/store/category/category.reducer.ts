import { createReducer, on } from '@ngrx/store';
import { initialState } from './category.state';
import {
  loadCategoriesFailure,
  loadCategoriesSuccess,
  loadShownOnMenuCategories,
} from './category.actions';

export const categoryReducer = createReducer(
  initialState,
  on(loadShownOnMenuCategories, (state) => ({
    ...state,
    loading: true,
    error: null,
  })),
  on(loadCategoriesSuccess, (state, { categories }) => ({
    ...state,
    categories,
    loading: false,
  })),
  on(loadCategoriesFailure, (state, { error }) => ({
    ...state,
    loading: false,
    error,
  })),
);
