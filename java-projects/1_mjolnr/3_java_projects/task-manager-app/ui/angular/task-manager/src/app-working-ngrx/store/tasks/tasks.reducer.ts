import { createReducer, on } from '@ngrx/store';
import { initialTaskState } from './task.state';
import { TasksActions } from './tasks.actions';

export const tasksReducer = createReducer(
  initialTaskState,
  on(TasksActions.loadTasks, (state) => ({ ...state, loading: true, error: null })),
  on(TasksActions.loadTasksSuccess, (state, { tasks }) => ({ ...state, tasks, loading: false })),
  on(TasksActions.loadTasksFailure, (state, { error }) => ({ ...state, loading: false, error })),
  on(TasksActions.setSearchTerm, (state, { searchTerm }) => ({ ...state, searchTerm })),
  on(TasksActions.setStatusFilter, (state, { statusFilter }) => ({ ...state, statusFilter })),
);
