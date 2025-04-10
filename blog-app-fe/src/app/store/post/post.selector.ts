import { createFeatureSelector, createSelector } from '@ngrx/store';
import { PostState } from './post.state';

export const selectPostState = createFeatureSelector<PostState>('posts');

export const selectPostsList = createSelector(
  selectPostState,
  (state) => state.posts,
);
export const selectPostPagination = createSelector(
  selectPostState,
  (state) => state.pagination,
);
export const selectPostLoading = createSelector(
  selectPostState,
  (state) => state.loading,
);

export const selectPostError = createSelector(
  selectPostState,
  (state) => state.error,
);
