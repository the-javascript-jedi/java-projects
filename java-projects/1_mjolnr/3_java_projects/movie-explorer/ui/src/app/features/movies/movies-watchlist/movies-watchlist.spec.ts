import { ComponentFixture, TestBed } from '@angular/core/testing';
import { MoviesWatchlist } from './movies-watchlist';

describe('MoviesWatchlist', () => {
  let component: MoviesWatchlist;
  let fixture: ComponentFixture<MoviesWatchlist>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MoviesWatchlist],
    }).compileComponents();

    fixture = TestBed.createComponent(MoviesWatchlist);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
