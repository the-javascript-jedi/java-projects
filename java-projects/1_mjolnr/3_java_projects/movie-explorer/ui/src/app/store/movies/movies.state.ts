import { Movie } from '../../core/models/movies';

export interface MovieState {
  Movies: Movie[];
}

export const initialState: MovieState = {
  Movies: [],
};
