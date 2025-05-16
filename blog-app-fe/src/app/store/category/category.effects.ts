import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { CategoryService } from './category.service';
import {
  loadCategoriesFailure,
  loadCategoriesSuccess,
  loadShownOnMenuCategories,
} from './category.actions';
import { catchError, map, mergeMap, of, pipe } from 'rxjs';

@Injectable()
export class CategoryEffects {
  constructor(
    private actions$: Actions,
    private categoryService: CategoryService,
  ) {}
  loadCategoryMenu$ = createEffect(() =>
    this.actions$.pipe(
      ofType(loadShownOnMenuCategories),
      mergeMap(() =>
        this.categoryService
          .getShowOnMenuCategories()
          .pipe(map((categories) => loadCategoriesSuccess({ categories }))),
      ),
      catchError((error) =>
        of(loadCategoriesFailure({ error: error.message })),
      ),
    ),
  );
}
