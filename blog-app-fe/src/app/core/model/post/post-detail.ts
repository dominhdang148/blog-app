import { AuthorItem } from '../author/author-item';
import { CategoryItem } from '../category/category-item';
import { TagItem } from '../tag/tag-item';

export interface PostDetail {
  id: string;
  title: string;
  shortDescription: string;
  imageUrl: string;
  viewCount: number;
  postedDate: string;
  modifiedDate: string;
  author: AuthorItem;
  category: CategoryItem;
  tags: TagItem[];
}
