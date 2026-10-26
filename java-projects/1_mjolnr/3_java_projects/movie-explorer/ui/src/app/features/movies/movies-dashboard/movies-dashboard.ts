import { Component, computed, inject, signal } from '@angular/core';
import { RouterLink } from '@angular/router';
import { mockMovies } from '../../../mock_data/mock_movies';
import { Movie } from '../../../core/models/movies';
import { toSignal } from '@angular/core/rxjs-interop';
import { Store } from '@ngrx/store';
import { selectMovies } from '../../../store/movies/movies.selector';
import { effect } from '@angular/core';

@Component({
  imports: [RouterLink],
  selector: 'app-movies-dashboard',
  styleUrl: './movies-dashboard.scss',
  templateUrl: './movies-dashboard.html',
})
export class MoviesDashboard {
  private readonly store = inject(Store);

  // movies = signal<Movie[]>(mockMovies);
  moviesSignal = toSignal(this.store.select(selectMovies), { initialValue: [] });

  searchQuery = signal('');
  filteredMovies = computed(() => {
    const query = this.searchQuery().trim().toLocaleLowerCase();
    if (!query) return this.moviesSignal();

    return this.moviesSignal().filter((movie) => movie.title.toLocaleLowerCase().includes(query));
  });

  constructor() {
    effect(() => {
      console.log('this.moviesSignal()', this.moviesSignal());
    });
  }
}
