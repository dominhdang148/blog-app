import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { Pagination } from 'src/app/core/model/pagination';
import { PostItem } from 'src/app/core/model/post/post-item';
import { loadPosts } from 'src/app/store/post/post.actions';
import {
  selectPostError,
  selectPostLoading,
  selectPostPagination,
  selectPostsList,
} from 'src/app/store/post/post.selector';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  keyword = '';
  currentPage = 1;
  pageSize = 3;
  posts$: Observable<PostItem[]>;
  pagination$: Observable<Pagination | null>;
  loading$: Observable<boolean>;
  error$: Observable<string | null>;
  constructor(
    private store: Store,
    private route: ActivatedRoute,
    private router: Router,
  ) {
    this.posts$ = this.store.select(selectPostsList);
    this.loading$ = this.store.select(selectPostLoading);
    this.pagination$ = this.store.select(selectPostPagination);
    this.error$ = this.store.select(selectPostError);
  }
  ngOnInit(): void {
    this.route.queryParams.subscribe((params) => {
      this.keyword = params['keyword'] || '';
      this.currentPage = params['page'] ? +params['page'] : 1;
      this.router.navigate([], {
        queryParams: {
          page: this.currentPage === 1 ? null : this.currentPage,
          keyword: this.keyword === '' ? null : this.keyword,
        },
        queryParamsHandling: 'merge',
      });
      this.store.dispatch(
        loadPosts({
          title: this.keyword,
          currentPage: this.currentPage - 1,
          pageSize: this.pageSize,
        }),
      );
    });
    this.pagination$ = this.store.select(selectPostPagination);
  }

  ngOnPageChange(newPage: number) {
    this.router.navigate([], {
      queryParams: { page: newPage === 0 ? null : newPage + 1 },
      queryParamsHandling: 'merge',
    });
    this.store.dispatch(
      loadPosts({
        title: this.keyword,
        currentPage: newPage,
        pageSize: this.pageSize,
      }),
    );
  }
}
