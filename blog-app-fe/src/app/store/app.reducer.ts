import { ActionReducerMap } from '@ngrx/store';
import { AppState } from './app.state';
import { categoryReducer } from './category/category.reducer';
import { postListReducer } from './post/post-list/post-list.reducer';
import { postDetailReducer } from './post/post-detail/post-detail.reducer';

export const appReducer: ActionReducerMap<AppState> = {
  category: categoryReducer,
  postList: postListReducer,
  postDetail: postDetailReducer,
};
