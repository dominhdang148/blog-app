import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { PostItem } from 'src/app/core/model/post/post-item';
import { loadPosts } from 'src/app/store/post/post.actions';
import {
  selectAllPosts,
  selectError,
  selectLoading,
} from 'src/app/store/post/post.selector';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  posts$: Observable<PostItem[]>;
  loading$: Observable<boolean>;
  error$: Observable<string | null>;
  constructor(private store: Store) {
    this.posts$ = this.store.select(selectAllPosts);
    this.loading$ = this.store.select(selectLoading);
    this.error$ = this.store.select(selectError);
  }
  ngOnInit(): void {
    this.store.dispatch(loadPosts());
    console.log(this.posts$.subscribe((posts) => posts));
  }
}
