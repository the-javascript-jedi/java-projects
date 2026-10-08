import { createAction, props } from '@ngrx/store';
import { Task } from '../../core/models/task.model';
import { StatusFilter } from './task.state';

export const loadTasks = createAction('[Tasks] Load Tasks');
export const loadTasksSuccess = createAction(
  '[Tasks] Load Tasks Success',
  props<{ tasks: Task[] }>(),
);
export const loadTasksFailure = createAction(
  '[Tasks] Load Tasks Failure',
  props<{ error: string }>(),
);

export const setSearchTerm = createAction(
  '[Tasks] Set Search Term',
  props<{ searchTerm: string }>(),
);
export const setSearchFilter = createAction(
  '[Tasks] Set Search Filter',
  props<{ searchFilter: StatusFilter }>(),
);

export const addTask = createAction(
  '[Task Form] Add Task',
  props<{ task: Omit<Task, 'id'> }>(),
);
export const updateTask = createAction(
  '[Task Form] Update Task',
  props<{ task: Task }>(),
);
