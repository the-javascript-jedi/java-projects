import { createAction, props } from '@ngrx/store';
import { Task, TaskInput } from '../../core/models/task.model';
import { StatusFilter } from './task.state';

// Every API call follows the same trio:
//   <action>         -> dispatched by a component, picked up by an effect
//   <action>Success  -> dispatched by the effect with the server's response
//   <action>Failure  -> dispatched by the effect when the HTTP call errors

// GET /tasks
export const loadTasks = createAction('[Tasks] Load Tasks');
export const loadTasksSuccess = createAction(
  '[Tasks] Load Tasks Success',
  props<{ tasks: Task[] }>(),
);
export const loadTasksFailure = createAction(
  '[Tasks] Load Tasks Failure',
  props<{ error: string }>(),
);

// GET /tasks/{id} — used by the details/edit pages so a page refresh still works.
export const loadTask = createAction(
  '[Task Page] Load Task',
  props<{ id: number }>(),
);
export const loadTaskSuccess = createAction(
  '[Tasks API] Load Task Success',
  props<{ task: Task }>(),
);
export const loadTaskFailure = createAction(
  '[Tasks API] Load Task Failure',
  props<{ error: string }>(),
);

// POST /tasks
export const addTask = createAction(
  '[Task Form] Add Task',
  props<{ task: TaskInput }>(),
);
export const addTaskSuccess = createAction(
  '[Tasks API] Add Task Success',
  props<{ task: Task }>(),
);
export const addTaskFailure = createAction(
  '[Tasks API] Add Task Failure',
  props<{ error: string }>(),
);

// PUT /tasks/{id}
export const updateTask = createAction(
  '[Task Form] Update Task',
  props<{ task: Task }>(),
);
export const updateTaskSuccess = createAction(
  '[Tasks API] Update Task Success',
  props<{ task: Task }>(),
);
export const updateTaskFailure = createAction(
  '[Tasks API] Update Task Failure',
  props<{ error: string }>(),
);

// DELETE /tasks/{id}
export const deleteTask = createAction(
  '[Task Details] Delete Task',
  props<{ id: number }>(),
);
export const deleteTaskSuccess = createAction(
  '[Tasks API] Delete Task Success',
  props<{ id: number }>(),
);
export const deleteTaskFailure = createAction(
  '[Tasks API] Delete Task Failure',
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
