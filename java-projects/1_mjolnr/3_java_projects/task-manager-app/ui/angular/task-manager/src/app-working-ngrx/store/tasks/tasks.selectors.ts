import { createFeatureSelector, createSelector } from '@ngrx/store';
import { TaskState } from './task.state';

export const selectTaskState = createFeatureSelector<TaskState>('tasks');

export const selectAllTasks = createSelector(selectTaskState, (state) => state.tasks);
export const selectLoading = createSelector(selectTaskState, (state) => state.loading);
export const selectError = createSelector(selectTaskState, (state) => state.error);
export const selectSearchTerm = createSelector(selectTaskState, (state) => state.searchTerm);
export const selectStatusFilter = createSelector(selectTaskState, (state) => state.statusFilter);

export const selectFilteredTasks = createSelector(
  selectAllTasks,
  selectSearchTerm,
  selectStatusFilter,
  (tasks, searchTerm, statusFilter) => {
    const search = searchTerm.trim().toLowerCase();

    return tasks.filter((task) => {
      const matchesSearch =
        task.title.toLowerCase().includes(search) ||
        task.description.toLowerCase().includes(search);
      const matchesFilter = statusFilter === 'All' || task.status === statusFilter;

      return matchesSearch && matchesFilter;
    });
  },
);
