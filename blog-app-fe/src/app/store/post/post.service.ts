import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { ApiResponse } from 'src/app/core/model/api-response';
import { Pagination } from 'src/app/core/model/pagination';
import { PostItem } from 'src/app/core/model/post/post-item';

@Injectable({
  providedIn: 'root',
})
export class PostService {
  private apiUrl = 'http://localhost:8080/api/post';
  constructor(private httpClient: HttpClient) {}
  getPosts(
    title: string = '',
    currentPage: number = 0,
    pageSize: number = 3,
  ): Observable<{ posts: PostItem[]; pagination: Pagination }> {
    return this.httpClient
      .get<
        ApiResponse<PostItem[]>
      >(`${this.apiUrl}?title=${title}&currentPage=${currentPage}&pageSize=${pageSize}`)
      .pipe(
        map((response) => ({
          posts: response.data,
          pagination: response.pagination,
        })),
      );
  }
}
