import { Component, inject, signal } from '@angular/core';
import { Task } from '../../../core/models/task.model';
import { RouterLink } from '@angular/router';
import {
  loadTasks,
  loadTasksSuccess,
  setSearchFilter,
  setSearchTerm,
} from '../../../store/tasks/tasks.actions';
import { Store } from '@ngrx/store';
import { initialTasks } from '../../../store/mocks/MOCK_TASKS';
import {
  selectAllTasks,
  selectFilteredTasks,
  selectSearchFilter,
  selectSearchTerm,
} from '../../../store/tasks/tasks.selectors';
import { FormsModule } from '@angular/forms';
import { effect } from '@angular/core';
import { StatusFilter } from '../../../store/tasks/task.state';
import { JsonPipe } from '@angular/common';

@Component({
  selector: 'app-task-dashboard',
  imports: [RouterLink, FormsModule, JsonPipe],
  templateUrl: './task-dashboard.component.html',
  styleUrl: './task-dashboard.component.scss',
})
export class TaskDashboardComponent {
  private readonly store = inject(Store);
  // signals with selector
  readonly tasks = this.store.selectSignal(selectFilteredTasks);
  readonly searchTodo = this.store.selectSignal(selectSearchTerm);
  readonly statusFilter = this.store.selectSignal(selectSearchFilter);

  // onSearch(value: string) {
  //   console.log('typed:', value);
  //   this.searchTodo.set(value);
  // }
  onSearch(event: Event) {
    const value = (event.target as HTMLInputElement).value;
    console.log('typed:', value);
    // this.searchTodo.set(value);
    this.store.dispatch(setSearchTerm({ searchTerm: value }));
  }

  updateStatusFilter(event: Event) {
    console.log('event', (event.target as HTMLSelectElement).value);
    // this.statusFilter.set((event.target as HTMLSelectElement).value);
    const status = (event.target as HTMLSelectElement).value;
    this.store.dispatch(
      setSearchFilter({ searchFilter: status as StatusFilter }),
    );
  }

  ngOnInit(): void {
    this.store.dispatch(loadTasks());
    this.store.dispatch(loadTasksSuccess({ tasks: initialTasks }));
  }
  constructor() {
    effect(() => {
      console.log(
        'search:',
        this.searchTodo(),
        '| filter:',
        this.statusFilter(),
      );
    });
  }
}
