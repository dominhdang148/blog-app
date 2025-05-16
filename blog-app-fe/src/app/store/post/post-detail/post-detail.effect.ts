import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { PostService } from '../post.service';
import {
  loadDetailPost,
  loadDetailPostFailure,
  loadDetailPostSuccess,
} from './post-detail.action';
import { catchError, map, mergeMap, of } from 'rxjs';

@Injectable()
export class PostDetailEffects {
  constructor(
    private actions$: Actions,
    private postService: PostService,
  ) {}
  loadDetailPost$ = createEffect(() =>
    this.actions$.pipe(
      ofType(loadDetailPost),
      mergeMap(({ year, month, day, slug }) =>
        this.postService.getPostDetail(year, month, day, slug).pipe(
          map((post) => loadDetailPostSuccess({ post: post })),
          catchError((error) =>
            of(loadDetailPostFailure({ error: error.message })),
          ),
        ),
      ),
    ),
  );
}
