import { Routes } from '@angular/router';
import { MoviesDashboard } from './features/movies/movies-dashboard/movies-dashboard';
import { MoviesDetails } from './features/movies/movies-details/movies-details';
import { MoviesWatchlist } from './features/movies/movies-watchlist/movies-watchlist';

export const routes: Routes = [
  {
    path: '',
    component: MoviesDashboard,
  },
  {
    path: 'movie/:id',
    component: MoviesDetails,
  },
  {
    path: 'watchlist',
    component: MoviesWatchlist,
  },
];
