import { ComponentFixture, TestBed } from '@angular/core/testing';
import { MoviesDetails } from './movies-details';

describe('MoviesDetails', () => {
  let component: MoviesDetails;
  let fixture: ComponentFixture<MoviesDetails>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MoviesDetails],
    }).compileComponents();

    fixture = TestBed.createComponent(MoviesDetails);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
