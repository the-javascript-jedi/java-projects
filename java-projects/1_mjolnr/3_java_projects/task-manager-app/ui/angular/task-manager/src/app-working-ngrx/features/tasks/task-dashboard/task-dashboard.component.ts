import { Component, inject, signal } from '@angular/core';
import { Task } from '../../../core/models/task.model';
import { RouterLink } from '@angular/router';
import {
  loadTasks,
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

  ngOnInit(): void {
    // The tasks effect picks this up and calls GET /tasks on the backend.
    this.store.dispatch(loadTasks());
  }
  // signals with selector
  readonly tasks = this.store.selectSignal(selectFilteredTasks);
}
