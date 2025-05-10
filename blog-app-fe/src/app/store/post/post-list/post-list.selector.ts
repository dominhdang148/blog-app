import { createFeatureSelector, createSelector } from '@ngrx/store';
import { PostListState } from './post-list.state';

export const selectPostListState =
  createFeatureSelector<PostListState>('posts');

export const selectPosts = createSelector(
  selectPostListState,
  (state) => state.posts,
);

export const selectPostsPagination = createSelector(
  selectPostListState,
  (state) => state.pagination,
);
export const selectPostsLoading = createSelector(
  selectPostListState,
  (state) => state.loading,
);

export const selectPostsError = createSelector(
  selectPostListState,
  (state) => state.error,
);
