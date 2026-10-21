import { inject } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { MoviesApiService } from '../../core/services/movies-api.service';
import * as MoviesAction from './movies.action';
import { catchError, exhaustMap, map, of, tap } from 'rxjs';
import { HttpErrorResponse } from '@angular/common/http';
import { mockMovies } from '../../mock_data/mock_movies';

// Prefer the message from Spring's GlobalExceptionHandler ({ error: "..." } or
// { field: "message" } for validation), fall back to Angular's generic message.
function toErrorMessage(error: HttpErrorResponse): string {
  const body = error.error;
  if (body && typeof body === 'object') {
    return Object.values(body).join(', ');
  }
  return error.message;
}

export const loadTask$ = createEffect(
  (action$ = inject(Actions), moviesApi = inject(MoviesApiService)) => {
    return action$.pipe(
      ofType(MoviesAction.loadMovies),
      exhaustMap(() =>
        moviesApi.getMovies().pipe(
          tap((moviesResult) => console.log('movies api', moviesResult)),
          map((moviesResult) => {
            return MoviesAction.loadMoviesSuccess({ movies: moviesResult });
          }),
          catchError((error: HttpErrorResponse) => {
            MoviesAction.loadMoviesSuccess({ movies: mockMovies });
            return of(MoviesAction.loadMoviesFailure({ error: toErrorMessage(error) }));
          }),
        ),
      ),
    );
  },
  { functional: true },
);
