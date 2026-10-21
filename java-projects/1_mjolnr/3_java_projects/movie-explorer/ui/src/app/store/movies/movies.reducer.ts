import { createReducer, on } from '@ngrx/store';
import { initialState } from './movies.state';
import { loadMoviesSuccess } from './movies.action';

export const moviesReducer = createReducer(
  initialState,
  on(loadMoviesSuccess, (state, { movies }) => ({ ...state, Movies: movies })),
);
