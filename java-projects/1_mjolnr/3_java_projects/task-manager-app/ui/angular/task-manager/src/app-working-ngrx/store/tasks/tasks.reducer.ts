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
  on(TaskActions.addTask, (state, { task }) => {
    // No backend yet, so make the next id from the current tasks.
    const nextId = Math.max(0, ...state.tasks.map((t) => t.id)) + 1;
    return { ...state, tasks: [...state.tasks, { ...task, id: nextId }] };
  }),
  on(TaskActions.updateTask, (state, { task }) => ({
    ...state,
    tasks: state.tasks.map((t) => (t.id === task.id ? task : t)),
  })),
);
