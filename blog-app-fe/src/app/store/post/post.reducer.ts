import { createReducer, on } from '@ngrx/store';
import { initialState } from './post.state';
import {
  loadPostFailure,
  loadPostSuccess,
  loadPosts,
  loadPostsAuthor,
  loadPostsCategory,
  loadPostsTag,
} from './post.actions';

export const postReducer = createReducer(
  initialState,
  on(loadPosts, loadPostsTag, loadPostsCategory, loadPostsAuthor, (state) => ({
    ...state,
    loading: true,
    error: null,
  })),

  on(loadPostSuccess, (state, { posts, pagination }) => ({
    ...state,
    posts,
    pagination,
    loading: false,
  })),

  on(loadPostFailure, (state, { error }) => ({
    ...state,
    loading: false,
    error,
  })),
);
