import { createReducer, on } from '@ngrx/store';
import {
  loadPostsFailure,
  loadPostsSuccess,
  loadPosts,
  loadPostsAuthor,
  loadPostsCategory,
  loadPostsTag,
} from './post-list.actions';
import { initialListState } from './post-list.state';

export const postListReducer = createReducer(
  initialListState,
  on(loadPosts, loadPostsTag, loadPostsCategory, loadPostsAuthor, (state) => ({
    ...state,
    loading: true,
    error: null,
  })),

  on(loadPostsSuccess, (state, { posts, pagination }) => ({
    ...state,
    posts: posts,
    pagination: pagination,
    loading: false,
  })),

  on(loadPostsFailure, (state, { error }) => ({
    ...state,
    loading: false,
    error: error,
  })),
);
