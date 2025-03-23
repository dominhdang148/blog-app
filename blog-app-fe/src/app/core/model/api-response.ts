import { Pagination } from './pagination';

export interface ApiResponse<T> {
  data: T;
  message: string;
  pagination: Pagination;
  status: string;
}
