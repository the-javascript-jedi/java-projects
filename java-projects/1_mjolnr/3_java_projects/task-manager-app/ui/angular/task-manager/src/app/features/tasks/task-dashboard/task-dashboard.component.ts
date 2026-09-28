import { Component, inject, signal } from '@angular/core';
import { Task } from '../../../core/models/task.model';
import { RouterLink } from '@angular/router';
import {
  loadTasks,
  loadTasksSuccess,
} from '../../../store/tasks/tasks.actions';
import { Store } from '@ngrx/store';
import { initialTasks } from '../../../store/mocks/MOCK_TASKS';
import { selectAllTasks } from '../../../store/tasks/tasks.selectors';

@Component({
  selector: 'app-task-dashboard',
  imports: [RouterLink],
  templateUrl: './task-dashboard.component.html',
  styleUrl: './task-dashboard.component.scss',
})
export class TaskDashboardComponent {
  private readonly store = inject(Store);

  ngOnInit(): void {
    this.store.dispatch(loadTasks());
    this.store.dispatch(loadTasksSuccess({ tasks: initialTasks }));
  }
  // simulate empty array using signals
  // readonly tasks = signal<Task[]>([]);

  //simulate hard coded arrays
  // readonly tasks = signal<Task[]>([
  //   {
  //     id: 1,
  //     title: 'Learn Spring Boot',
  //     description: 'Understand controllers and services',
  //     dueDate: 'Sep 16',
  //     status: 'TODO',
  //   },
  //   {
  //     id: 2,
  //     title: 'Build Task Manager UI',
  //     description: 'Create Angular frontend',
  //     dueDate: 'Sep 14',
  //     status: 'DONE',
  //   },
  //   {
  //     id: 3,
  //     title: 'Learn NgRx effects',
  //     description: 'Connect store actions to HTTP requests',
  //     dueDate: 'Sep 18',
  //     status: 'IN_PROGRESS',
  //   },
  // ]);

  //
  readonly tasks = this.store.selectSignal(selectAllTasks);
}
