import { createActionGroup, emptyProps, props } from '@ngrx/store';
import { Task } from '../../core/models/task.model';
import { StatusFilter } from './task.state';

export const TasksActions = createActionGroup({
  source: 'Tasks',
  events: {
    'Load Tasks': emptyProps(),
    'Load Tasks Success': props<{ tasks: Task[] }>(),
    'Load Tasks Failure': props<{ error: string }>(),
    'Set Search Term': props<{ searchTerm: string }>(),
    'Set Status Filter': props<{ statusFilter: StatusFilter }>(),
  },
});
