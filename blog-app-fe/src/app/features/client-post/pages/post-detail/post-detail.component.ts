import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { PostDetail } from 'src/app/core/model/post/post-detail';
import { loadDetailPost } from 'src/app/store/post/post-detail/post-detail.action';
import {
  selectPostDetail,
  selectPostDetailErorr,
  selectPostDetailLoading,
} from 'src/app/store/post/post-detail/post-detail.selector';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.css'],
})
export class PostDetailComponent implements OnInit {
  slug!: string;
  year!: number;
  month!: number;
  day!: number;
  post$: Observable<PostDetail | null>;
  loading$: Observable<boolean>;
  error$: Observable<string | null>;
  constructor(
    private store: Store,
    private route: ActivatedRoute,
  ) {
    this.post$ = this.store.select(selectPostDetail);
    this.loading$ = this.store.select(selectPostDetailLoading);
    this.error$ = this.store.select(selectPostDetailErorr);
  }
  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      this.year = Number(params.get('year')!);
      this.month = Number(params.get('month')!);
      this.day = Number(params.get('day')!);
      this.slug = params.get('slug')!;
      console.log(this.year);
      console.log(this.month);
      console.log(this.day);
      console.log(this.slug);

      this.store.dispatch(
        loadDetailPost({
          year: this.year,
          month: this.month,
          day: this.day,
          slug: this.slug,
        }),
      );
    });
  }
}
