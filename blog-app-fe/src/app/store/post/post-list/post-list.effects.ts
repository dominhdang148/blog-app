import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { PostService } from '../post.service';
import {
  loadPostsFailure,
  loadPostsSuccess,
  loadPosts,
  loadPostsAuthor,
  loadPostsCategory,
  loadPostsTag,
} from './post-list.actions';
import { catchError, map, mergeMap, of } from 'rxjs';
import { CategoryService } from '../../category/category.service';
import { AuthorService } from '../../author/author.service';
import { TagService } from '../../tag/tag.service';

@Injectable()
export class PostListEffects {
  constructor(
    private actions$: Actions,
    private postService: PostService,
    private categoryService: CategoryService,
    private authorService: AuthorService,
    private tagService: TagService,
  ) {}

  loadPosts$ = createEffect(() =>
    this.actions$.pipe(
      ofType(loadPosts),
      mergeMap(({ title, currentPage, pageSize }) =>
        this.postService.getPosts(title, currentPage, pageSize).pipe(
          map(({ posts, pagination }) =>
            loadPostsSuccess({ posts, pagination }),
          ),
          catchError((error) => of(loadPostsFailure({ error: error.message }))),
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
              loadPostsSuccess({ posts, pagination }),
            ),
            catchError((error) =>
              of(loadPostsFailure({ error: error.message })),
            ),
          ),
      ),
    ),
  );

  loadPostsTag$ = createEffect(() =>
    this.actions$.pipe(
      ofType(loadPostsTag),
      mergeMap(({ slug, currentPage, pageSize }) =>
        this.tagService.getPostByTagSlug(slug, currentPage, pageSize).pipe(
          map(({ posts, pagination }) =>
            loadPostsSuccess({ posts, pagination }),
          ),
          catchError((error) => of(loadPostsFailure({ error: error.message }))),
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
              loadPostsSuccess({ posts, pagination }),
            ),
            catchError((error) =>
              of(loadPostsFailure({ error: error.message })),
            ),
          ),
      ),
    ),
  );
}
