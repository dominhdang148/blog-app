import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { ApiResponse } from 'src/app/core/model/api-response';
import { CategoryItem } from 'src/app/core/model/category/category-item';

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
}
