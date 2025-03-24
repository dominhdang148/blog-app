import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { PostService } from './post.service';
import { loadPostFailure, loadPostSuccess, loadPosts } from './post.actions';
import { catchError, map, mergeMap, of } from 'rxjs';

@Injectable()
export class PostEffects {
  constructor(
    private actions$: Actions,
    private postService: PostService,
  ) {}
  loadPosts$ = createEffect(() =>
    this.actions$.pipe(
      ofType(loadPosts),
      mergeMap(({ title, currentPage, pageSize }) =>
        this.postService.getPosts(title, currentPage, pageSize).pipe(
          map(({ posts, pagination }) =>
            loadPostSuccess({ posts, pagination }),
          ),
          catchError((error) => of(loadPostFailure({ error: error.message }))),
        ),
      ),
    ),
  );
}
