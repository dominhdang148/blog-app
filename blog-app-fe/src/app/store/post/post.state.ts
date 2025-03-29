import { EntityState, createEntityAdapter } from '@ngrx/entity';
import { Pagination } from 'src/app/core/model/pagination';
import { PostItem } from 'src/app/core/model/post/post-item';

export interface PostState extends EntityState<PostItem> {
  posts: PostItem[];
  pagination: Pagination | null;
  loading: boolean;
  error: string | null;
}

export const postAdapter = createEntityAdapter<PostItem>();

export const initialState: PostState = postAdapter.getInitialState({
  posts: [],
  pagination: null,
  loading: false,
  error: null,
});
