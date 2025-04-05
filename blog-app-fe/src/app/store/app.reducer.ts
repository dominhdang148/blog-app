import { ActionReducerMap } from '@ngrx/store';
import { AppState } from './app.state';
import { postReducer } from './post/post.reducer';
import { categoryReducer } from './category/category.reducer';

export const appReducer: ActionReducerMap<AppState> = {
  category: categoryReducer,
  post: postReducer,
};
