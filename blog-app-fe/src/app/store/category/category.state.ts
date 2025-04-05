import { EntityState, createEntityAdapter } from '@ngrx/entity';
import { CategoryItem } from 'src/app/core/model/category/category-item';

export interface CategoryState extends EntityState<CategoryItem> {
  categories: CategoryItem[];
  loading: boolean;
  error: string | null;
}

export const categoryAdapter = createEntityAdapter<CategoryItem>();

export const initialState: CategoryState = categoryAdapter.getInitialState({
  categories: [],
  loading: false,
  error: null,
});
