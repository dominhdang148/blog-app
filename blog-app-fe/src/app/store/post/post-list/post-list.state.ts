import { EntityState, createEntityAdapter } from '@ngrx/entity';
import { Pagination } from 'src/app/core/model/pagination';
import { PostItem } from 'src/app/core/model/post/post-item';

export interface PostListState extends EntityState<PostItem> {
  posts: PostItem[];
  pagination: Pagination | null;
  loading: boolean;
  error: string | null;
}

export const postListAdapter = createEntityAdapter<PostItem>();

export const initialListState: PostListState = postListAdapter.getInitialState({
  posts: [],
  pagination: null,
  loading: false,
  error: null,
});
