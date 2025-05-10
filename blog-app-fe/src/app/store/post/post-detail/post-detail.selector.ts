import { createFeatureSelector, createSelector } from '@ngrx/store';
import { PostDetailState } from './post-detail.state';

export const selectPostDetailState =
  createFeatureSelector<PostDetailState>('postDetail');

export const selectPostDetail = createSelector(
  selectPostDetailState,
  (state) => state.post,
);

export const selectPostDetailLoading = createSelector(
  selectPostDetailState,
  (state) => state.loading,
);

export const selectPostDetailErorr = createSelector(
  selectPostDetailState,
  (state) => state.error,
);
