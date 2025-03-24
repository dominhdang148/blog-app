import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { Pagination } from 'src/app/core/model/pagination';
import { PostItem } from 'src/app/core/model/post/post-item';
import { loadPosts } from 'src/app/store/post/post.actions';
import {
  selectAllPosts,
  selectError,
  selectLoading,
  selectPagination,
} from 'src/app/store/post/post.selector';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  currentPage = 0;
  pageSize = 3;
  posts$: Observable<PostItem[]>;
  pagination$: Observable<Pagination | null>;
  loading$: Observable<boolean>;
  error$: Observable<string | null>;
  constructor(private store: Store) {
    this.posts$ = this.store.select(selectAllPosts);
    this.loading$ = this.store.select(selectLoading);
    this.pagination$ = this.store.select(selectPagination);
    this.error$ = this.store.select(selectError);
  }
  ngOnInit(): void {
    this.loadPosts();
  }
  loadPosts() {
    this.store.dispatch(
      loadPosts({
        title: '',
        currentPage: this.currentPage,
        pageSize: this.pageSize,
      }),
    );
  }
  ngOnPageChange(newPage: number) {
    this.currentPage = newPage;
    this.loadPosts();
  }
}
