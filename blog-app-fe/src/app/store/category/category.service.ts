import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { ApiResponse } from 'src/app/core/model/api-response';
import { CategoryItem } from 'src/app/core/model/category/category-item';
import { Pagination } from 'src/app/core/model/pagination';
import { PostItem } from 'src/app/core/model/post/post-item';

@Injectable({
  providedIn: 'root',
})
export class CategoryService {
  private apiUrl = 'http://localhost:8080/api/category';
  constructor(private httpClient: HttpClient) {}
  getShowOnMenuCategories(): Observable<CategoryItem[]> {
    return this.httpClient
      .get<ApiResponse<CategoryItem[]>>(this.apiUrl)
      .pipe(map((response) => response.data));
  }
  getPostsByCategory(
    slug: string,
    currentPage: number = 0,
    pageSize: number = 3,
  ): Observable<{
    posts: PostItem[];
    pagination: Pagination;
  }> {
    return this.httpClient
      .get<ApiResponse<PostItem[]>>(`${this.apiUrl}/${slug}/posts`)
      .pipe(
        map((response) => ({
          posts: response.data,
          pagination: response.pagination,
        })),
      );
  }
}
