import { createReducer, on } from '@ngrx/store';
import { Task } from '../../core/models/task.model';
import { initialTaskState } from './task.state';
import * as TaskActions from './tasks.actions';

// Replace the task with the same id, or append it if it isn't in the list yet.
function upsert(tasks: Task[], task: Task): Task[] {
  return tasks.some((t) => t.id === task.id)
    ? tasks.map((t) => (t.id === task.id ? task : t))
    : [...tasks, task];
}

export const tasksReducer = createReducer(
  initialTaskState,

  // Every request: start loading, clear the old error.
  on(
    TaskActions.loadTasks,
    TaskActions.loadTask,
    TaskActions.addTask,
    TaskActions.updateTask,
    TaskActions.deleteTask,
    (state) => ({ ...state, loading: true, error: null }),
  ),

  // Every failure: stop loading, keep the message for the UI.
  on(
    TaskActions.loadTasksFailure,
    TaskActions.loadTaskFailure,
    TaskActions.addTaskFailure,
    TaskActions.updateTaskFailure,
    TaskActions.deleteTaskFailure,
    (state, { error }) => ({ ...state, loading: false, error }),
  ),

  on(TaskActions.loadTasksSuccess, (state, { tasks }) => ({
    ...state,
    tasks,
    loading: false,
  })),

  // The store only changes once the server says OK, and uses the server's
  // copy (so a new task gets its real DB id, not one we made up).
  on(
    TaskActions.loadTaskSuccess,
    TaskActions.addTaskSuccess,
    TaskActions.updateTaskSuccess,
    (state, { task }) => ({
      ...state,
      tasks: upsert(state.tasks, task),
      loading: false,
    }),
  ),

  on(TaskActions.deleteTaskSuccess, (state, { id }) => ({
    ...state,
    tasks: state.tasks.filter((t) => t.id !== id),
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
