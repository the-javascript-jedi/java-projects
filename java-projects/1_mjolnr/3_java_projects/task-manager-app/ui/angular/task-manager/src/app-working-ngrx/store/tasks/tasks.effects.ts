import { inject } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { catchError, exhaustMap, map, of } from 'rxjs';
import { Task } from '../../core/models/task.model';
import { TasksActions } from './tasks.actions';

// TODO: replace this with TaskApiService.getTasks() once the backend is wired up.
const MOCK_TASKS: Task[] = [
  {
    id: 1,
    title: 'Learn Spring Boot',
    description: 'Understand controllers and services',
    dueDate: 'Sep 16',
    status: 'TODO',
  },
  {
    id: 2,
    title: 'Build Task Manager UI',
    description: 'Create Angular frontend',
    dueDate: 'Sep 14',
    status: 'DONE',
  },
  {
    id: 3,
    title: 'Learn NgRx effects',
    description: 'Connect store actions to HTTP requests',
    dueDate: 'Sep 18',
    status: 'IN_PROGRESS',
  },
];

export const loadTasks$ = createEffect(
  (actions$ = inject(Actions)) => {
    return actions$.pipe(
      ofType(TasksActions.loadTasks),
      exhaustMap(() =>
        of(MOCK_TASKS).pipe(
          map((tasks) => TasksActions.loadTasksSuccess({ tasks })),
          catchError((error: Error) => of(TasksActions.loadTasksFailure({ error: error.message }))),
        ),
      ),
    );
  },
  { functional: true },
);

export const TasksEffects = { loadTasks$ };
