import { Component, inject, OnInit } from '@angular/core';
import { RouterLink, RouterOutlet } from '@angular/router';
import { Store } from '@ngrx/store';
import { loadTasks, loadTasksSuccess } from './store/tasks/tasks.actions';
import { initialTasks } from './store/mocks/MOCK_TASKS';

@Component({
  selector: 'app-root',
  imports: [RouterLink, RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
})
export class AppComponent implements OnInit {
  title = 'task-manager';
  private readonly store = inject(Store);

  // Load tasks once for the whole app, so every page (dashboard, details,
  // edit) has data — even when the user refreshes directly on /tasks/2.
  ngOnInit(): void {
    this.store.dispatch(loadTasks());
    this.store.dispatch(loadTasksSuccess({ tasks: initialTasks }));
  }
}
