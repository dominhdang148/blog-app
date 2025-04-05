import { CategoryState } from './category/category.state';
import { PostState } from './post/post.state';

export interface AppState {
  category: CategoryState;
  post: PostState;
}
