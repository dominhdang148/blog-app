import { createAction, props } from '@ngrx/store';
import { Pagination } from 'src/app/core/model/pagination';
import { PostItem } from 'src/app/core/model/post/post-item';

export const loadPosts = createAction(
  '[Post] Load Posts',
  props<{ title: string; currentPage: number; pageSize: number }>(),
);

export const loadPostsCategory = createAction(
  '[Post] Load Posts By Category',
  props<{ slug: string; currentPage: number; pageSize: number }>(),
);

export const loadPostSuccess = createAction(
  '[Post] Load Post Success',
  props<{ posts: PostItem[]; pagination: Pagination }>(),
);
export const loadPostFailure = createAction(
  '[Post] Load Post Failure',
  props<{ error: string }>(),
);
