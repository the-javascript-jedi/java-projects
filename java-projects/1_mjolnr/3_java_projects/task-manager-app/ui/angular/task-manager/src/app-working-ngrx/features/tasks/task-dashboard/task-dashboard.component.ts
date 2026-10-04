import { Component, inject, signal } from '@angular/core';
import { Task } from '../../../core/models/task.model';
import { RouterLink } from '@angular/router';
import {
  setSearchFilter,
  setSearchTerm,
} from '../../../store/tasks/tasks.actions';
import { Store } from '@ngrx/store';
import {
  selectAllTasks,
  selectFilteredTasks,
} from '../../../store/tasks/tasks.selectors';
import { FormsModule } from '@angular/forms';
import { effect } from '@angular/core';
import { StatusFilter } from '../../../store/tasks/task.state';

@Component({
  selector: 'app-task-dashboard',
  imports: [RouterLink, FormsModule],
  templateUrl: './task-dashboard.component.html',
  styleUrl: './task-dashboard.component.scss',
})
export class TaskDashboardComponent {
  searchTodo = signal('');
  statusFilter = signal('All');

  // onSearch(value: string) {
  //   console.log('typed:', value);
  //   this.searchTodo.set(value);
  // }
  onSearch(event: Event) {
    const value = (event.target as HTMLInputElement).value;
    console.log('typed:', value);
    this.searchTodo.set(value);
    this.store.dispatch(setSearchTerm({ searchTerm: value }));
  }

  updateStatusFilter(event: Event) {
    console.log('event', (event.target as HTMLSelectElement).value);
    this.statusFilter.set((event.target as HTMLSelectElement).value);
    const status = (event.target as HTMLSelectElement).value;
    this.store.dispatch(
      setSearchFilter({ searchFilter: status as StatusFilter }),
    );
  }
  private readonly store = inject(Store);
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

  // signals with selector
  readonly tasks = this.store.selectSignal(selectFilteredTasks);
}
