import { createAction, props } from '@ngrx/store';
import { PostDetail } from 'src/app/core/model/post/post-detail';

export const loadDetailPost = createAction(
  '[Post] Load Detail Post',
  props<{ year: number; month: number; day: number; slug: string }>(),
);

export const loadDetailPostSuccess = createAction(
  '[Post] Load Detail Post Success',
  props<{ post: PostDetail }>(),
);

export const loadDetailPostFailure = createAction(
  '[Post] Load Detail Post Failure',
  props<{ error: string }>(),
);
