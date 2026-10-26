import { createFeatureSelector, createSelector } from '@ngrx/store';

import { MovieState } from './movies.state';

// this should match from the app.config provideStore({ movies: moviesReducer }),
export const selectMoviesState = createFeatureSelector<MovieState>('movies');

export const selectMovies = createSelector(selectMoviesState, (state) => state.Movies);
