import { createFeatureSelector, createSelector } from '@ngrx/store';
import { TaskState } from './task.state';

export const selectTaskState = createFeatureSelector<TaskState>('tasks');

export const selectAllTasks = createSelector(
  selectTaskState,
  (state) => state.tasks,
);
export const selectLoading = createSelector(
  selectTaskState,
  (state) => state.loading,
);
export const selectError = createSelector(
  selectTaskState,
  (state) => state.error,
);
export const selectSearchTerm = createSelector(
  selectTaskState,
  (state) => state.searchTerm,
);
export const selectSearchFilter = createSelector(
  selectTaskState,
  (state) => state.searchFilter,
);
