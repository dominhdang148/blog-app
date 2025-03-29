import { createFeatureSelector, createSelector } from '@ngrx/store';
import { PostState, postAdapter } from './post.state';
import { state } from '@angular/animations';

export const selectPostState = createFeatureSelector<PostState>('posts');

export const selectAllPosts = createSelector(
  selectPostState,
  (state) => state.posts,
);
export const selectPagination = createSelector(
  selectPostState,
  (state) => state.pagination,
);
export const selectLoading = createSelector(
  selectPostState,
  (state) => state.loading,
);

export const selectError = createSelector(
  selectPostState,
  (state) => state.error,
);
