import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { Pagination } from 'src/app/core/model/pagination';
import { PostItem } from 'src/app/core/model/post/post-item';
import { loadPosts, loadPostsCategory } from 'src/app/store/post/post.actions';
import {
  selectPostError,
  selectPostLoading,
  selectPostPagination,
  selectPostsList,
} from 'src/app/store/post/post.selector';

@Component({
  selector: 'app-post-by-category',
  templateUrl: './post-by-category.component.html',
  styleUrls: ['./post-by-category.component.css'],
})
export class PostByCategoryComponent implements OnInit {
  slug!: string;
  currentPage = 1;
  pageSize = 3;
  posts$: Observable<PostItem[]>;
  pagination$: Observable<Pagination | null>;
  loading$: Observable<boolean>;
  error$: Observable<string | null>;
  constructor(
    private store: Store,
    private router: Router,
    private route: ActivatedRoute,
  ) {
    this.posts$ = this.store.select(selectPostsList);
    this.pagination$ = this.store.select(selectPostPagination);
    this.loading$ = this.store.select(selectPostLoading);
    this.error$ = this.store.select(selectPostError);
  }
  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      this.slug = params.get('slug')!;
      this.store.dispatch(
        loadPostsCategory({
          slug: this.slug,
          currentPage: this.currentPage - 1,
          pageSize: this.pageSize,
        }),
      );
    });

    this.pagination$ = this.store.select(selectPostPagination);
  }

  ngOnPageChange(newPage: number) {
    this.router.navigate([], {
      queryParams: { page: newPage == 0 ? null : newPage + 1 },
      queryParamsHandling: 'merge',
    });

    this.store.dispatch(
      loadPostsCategory({
        slug: this.slug,
        currentPage: newPage,
        pageSize: this.pageSize,
      }),
    );
  }
}
