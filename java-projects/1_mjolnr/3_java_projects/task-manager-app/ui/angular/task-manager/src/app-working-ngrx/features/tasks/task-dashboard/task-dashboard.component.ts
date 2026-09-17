import { Component, inject, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Store } from '@ngrx/store';
import { StatusFilter } from '../../../store/tasks/task.state';
import { TasksActions } from '../../../store/tasks/tasks.actions';
import {
  selectFilteredTasks,
  selectSearchTerm,
  selectStatusFilter,
} from '../../../store/tasks/tasks.selectors';

@Component({
  selector: 'app-task-dashboard',
  imports: [RouterLink],
  templateUrl: './task-dashboard.component.html',
  styleUrl: './task-dashboard.component.scss',
})
export class TaskDashboardComponent implements OnInit {
  private readonly store = inject(Store);

  readonly filteredTasks = this.store.selectSignal(selectFilteredTasks);
  readonly searchTerm = this.store.selectSignal(selectSearchTerm);
  readonly statusFilter = this.store.selectSignal(selectStatusFilter);

  ngOnInit(): void {
    this.store.dispatch(TasksActions.loadTasks());
  }

  updateStatusFilter(event: Event): void {
    const selected = event.target as HTMLSelectElement;
    this.store.dispatch(
      TasksActions.setStatusFilter({ statusFilter: selected.value as StatusFilter }),
    );
  }

  updateSearch(event: Event): void {
    const input = event.target as HTMLInputElement;
    this.store.dispatch(TasksActions.setSearchTerm({ searchTerm: input.value }));
  }
}
