import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map, tap } from 'rxjs';
import { ApiResponse } from 'src/app/core/model/api-response';
import { Pagination } from 'src/app/core/model/pagination';
import { PostDetail } from 'src/app/core/model/post/post-detail';
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
        tap((data) => console.log(data)),
      );
  }

  getPostDetail(
    year: number,
    month: number,
    day: number,
    slug: string,
  ): Observable<PostDetail> {
    return this.httpClient
      .get<
        ApiResponse<PostDetail>
      >(`${this.apiUrl}/${year}/${month}/${day}/${slug}`)
      .pipe(
        map((response) => response.data),
        tap((data) => console.log(data)),
      );
  }
}
