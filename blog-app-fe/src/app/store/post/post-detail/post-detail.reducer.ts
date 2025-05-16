import { createReducer, on } from '@ngrx/store';
import { initialDetailState } from './post-detail.state';
import {
  loadDetailPost,
  loadDetailPostFailure,
  loadDetailPostSuccess,
} from './post-detail.action';

export const postDetailReducer = createReducer(
  initialDetailState,
  on(loadDetailPost, (state) => ({
    ...state,
    loading: true,
    error: null,
  })),
  on(loadDetailPostSuccess, (state, { post }) => ({
    ...state,
    post: post,
    loading: false,
  })),
  on(loadDetailPostFailure, (state, { error }) => ({
    ...state,
    loading: false,
    error: error,
  })),
);
