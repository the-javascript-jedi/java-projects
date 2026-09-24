import { createReducer, on } from '@ngrx/store';
import { Task } from '../../core/models/task.model';
import { initialTaskState, StatusFilter } from './task.state';
import * as TaskActions from './tasks.actions';

export const tasksReducer = createReducer(
  initialTaskState,

  on(TaskActions.loadTasks, (state) => ({
    ...state,
    loading: true,
    error: null,
  })),
  on(TaskActions.loadTasksSuccess, (state, { tasks }) => ({
    ...state,
    tasks: tasks,
    loading: false,
    error: null,
  })),
  on(TaskActions.loadTasksFailure, (state, { error }) => ({
    ...state,
    error: error,
    loading: false,
  })),
  on(TaskActions.setSearchTerm, (state, { searchTerm }) => ({
    ...state,
    searchTerm,
  })),
  on(TaskActions.setSearchFilter, (state, { searchFilter }) => ({
    ...state,
    searchFilter,
  })),
);
