import { EntityState, createEntityAdapter } from '@ngrx/entity';
import { PostDetail } from 'src/app/core/model/post/post-detail';

export interface PostDetailState extends EntityState<PostDetail> {
  post: PostDetail | null;
  loading: boolean;
  error: string | null;
}

export const postDetailAdapter = createEntityAdapter<PostDetail>();

export const initialDetailState: PostDetailState =
  postDetailAdapter.getInitialState({
    post: null,
    loading: false,
    error: null,
  });
