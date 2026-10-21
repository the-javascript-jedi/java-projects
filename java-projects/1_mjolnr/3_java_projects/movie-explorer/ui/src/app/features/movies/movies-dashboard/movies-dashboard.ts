import { Component, signal } from '@angular/core';
import { RouterLink } from '@angular/router';
import { mockMovies } from '../../../mock_data/mock_movies';
import { Movie } from '../../../core/models/movies';

@Component({
  imports: [RouterLink],
  selector: 'app-movies-dashboard',
  styleUrl: './movies-dashboard.scss',
  templateUrl: './movies-dashboard.html',
})
export class MoviesDashboard {
  movies = signal<Movie[]>(mockMovies);

  constructor() {
    console.log('movies', this.movies());
  }
}
