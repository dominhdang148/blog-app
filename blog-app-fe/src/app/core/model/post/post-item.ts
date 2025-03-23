import { AuthorItem } from '../author/author-item';
import { CategoryItem } from '../category/category-item';
import { TagItem } from '../tag/tag-item';

export interface PostItem {
  id: string;
  title: string;
  shortDescription: string;
  urlSlug: string;
  imageUrl: string;
  viewCount: number;
  postedDate: string;
  author: AuthorItem;
  category: CategoryItem;
  tags: TagItem[];
}
