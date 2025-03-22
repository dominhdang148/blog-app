import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { ApiResponse } from 'src/app/core/model/api-response';
import { PostItem } from 'src/app/core/model/post/post-item';

@Injectable({
  providedIn: 'root',
})
export class PostService {
  private apiUrl = 'http://localhost:8080/api/post';
  constructor(private httpClient: HttpClient) {}
  getPosts(): Observable<PostItem[]> {
    return this.httpClient
      .get<ApiResponse<PostItem[]>>(this.apiUrl)
      .pipe(map((response) => response.data));
  }
}
