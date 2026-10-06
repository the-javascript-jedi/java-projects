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
export const selectFilteredTasks = createSelector(
  selectAllTasks,
  selectSearchTerm,
  selectSearchFilter,
  (tasks, searchTerm, searchFilter) => {
    console.log('tasks', tasks);
    console.log('searchTerm', searchTerm);
    console.log('searchFilter', searchFilter);
    const search = searchTerm.trim().toLowerCase();
    return tasks.filter((task) => {
      const matchesSearch =
        task.title.toLowerCase().includes(search) ||
        task.description.toLowerCase().includes(search);
      const matchesFilter =
        searchFilter === 'All' || task.status === searchFilter;
      return matchesSearch && matchesFilter;
    });
  },
);

export const selectTaskById = (id: number | string) => {
  return createSelector(selectAllTasks, (tasks) => {
    return tasks.find((task) => task.id == id);
  });
};
