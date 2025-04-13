import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { PostService } from './post.service';
import {
  loadPostFailure,
  loadPostSuccess,
  loadPosts,
  loadPostsAuthor,
  loadPostsCategory,
} from './post.actions';
import { catchError, map, mergeMap, of } from 'rxjs';
import { CategoryService } from '../category/category.service';
import { AuthorService } from '../author/author.service';

@Injectable()
export class PostEffects {
  constructor(
    private actions$: Actions,
    private postService: PostService,
    private categoryService: CategoryService,
    private authorService: AuthorService,
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

  loadPostsCategory$ = createEffect(() =>
    this.actions$.pipe(
      ofType(loadPostsCategory),

      mergeMap(({ slug, currentPage, pageSize }) =>
        this.categoryService
          .getPostsByCategory(slug, currentPage, pageSize)
          .pipe(
            map(({ posts, pagination }) =>
              loadPostSuccess({ posts, pagination }),
            ),
            catchError((error) =>
              of(loadPostFailure({ error: error.message })),
            ),
          ),
      ),
    ),
  );

  loadPostsAuthor$ = createEffect(() =>
    this.actions$.pipe(
      ofType(loadPostsAuthor),
      mergeMap(({ slug, currentPage, pageSize }) =>
        this.authorService
          .getPostsByAuthorSlug(slug, currentPage, pageSize)
          .pipe(
            map(({ posts, pagination }) =>
              loadPostSuccess({ posts, pagination }),
            ),
            catchError((error) =>
              of(loadPostFailure({ error: error.message })),
            ),
          ),
      ),
    ),
  );
}
