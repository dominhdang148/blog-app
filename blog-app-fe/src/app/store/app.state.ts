import { CategoryState } from './category/category.state';
import { PostDetailState } from './post/post-detail/post-detail.state';
import { PostListState } from './post/post-list/post-list.state';

export interface AppState {
  category: CategoryState;
  postList: PostListState;
  postDetail: PostDetailState;
}
