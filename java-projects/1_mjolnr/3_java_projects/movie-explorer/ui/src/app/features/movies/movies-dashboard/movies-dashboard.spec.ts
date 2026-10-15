import { ComponentFixture, TestBed } from '@angular/core/testing';
import { MoviesDashboard } from './movies-dashboard';

describe('MoviesDashboard', () => {
  let component: MoviesDashboard;
  let fixture: ComponentFixture<MoviesDashboard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MoviesDashboard],
    }).compileComponents();

    fixture = TestBed.createComponent(MoviesDashboard);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
