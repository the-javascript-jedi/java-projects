import { Component, inject, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Header } from './shared/header/header';
import { Store } from '@ngrx/store';
import { loadMovies } from './store/movies/movies.action';

@Component({
  imports: [RouterOutlet, Header],
  selector: 'app-root',
  styleUrl: './app.scss',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('movie-explorer');
  private readonly store = inject(Store);

  ngOnInit(): void {
    this.store.dispatch(loadMovies());
  }
}
