import { createAction, props } from '@ngrx/store';
import { PostItem } from 'src/app/core/model/post/post-item';

export const loadPosts = createAction('[Post] Load Posts');
export const loadPostSuccess = createAction(
  '[Product] Load Product Success',
  props<{ posts: PostItem[] }>(),
);
export const loadPostFailure = createAction(
  '[Product] Load Product Failure',
  props<{ error: string }>(),
);
