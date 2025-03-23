import { EntityState, createEntityAdapter } from '@ngrx/entity';
import { PostItem } from 'src/app/core/model/post/post-item';

export interface PostState extends EntityState<PostItem> {
  loading: boolean;
  error: string | null;
}

export const postAdapter = createEntityAdapter<PostItem>();

export const initialState: PostState = postAdapter.getInitialState({
  loading: false,
  error: null,
});
