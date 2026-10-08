import { inject } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { catchError, exhaustMap, map, of } from 'rxjs';
import { TaskApiService } from '../../core/services/task-api.service';
import * as TaskActions from './tasks.actions';

// Listens for loadTasks, calls the API, then dispatches success or failure.
export const loadTasks$ = createEffect(
  (actions$ = inject(Actions), taskApi = inject(TaskApiService)) => {
    return actions$.pipe(
      ofType(TaskActions.loadTasks),
      exhaustMap(() =>
        taskApi.getTasks().pipe(
          map((tasks) => TaskActions.loadTasksSuccess({ tasks })),
          catchError((error: Error) =>
            of(TaskActions.loadTasksFailure({ error: error.message })),
          ),
        ),
      ),
    );
  },
  { functional: true },
);

export const TasksEffects = { loadTasks$ };
