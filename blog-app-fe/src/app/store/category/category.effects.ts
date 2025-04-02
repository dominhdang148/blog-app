import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { CategoryService } from './category.service';
import { loadShownOnMenuCategories } from './category.actions';

@Injectable()
export class CategoryEffects {
  constructor(
    private actions$: Actions,
    private categoryService: CategoryService,
  ) {}
  loadCategoryMenu$ = createEffect(() =>
    this.actions$.pipe(ofType(loadShownOnMenuCategories)),
  );
}
