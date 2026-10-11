import { Actions, createEffect, ofType } from '@ngrx/effects';
import { TaskApiService } from '../../core/services/task-api.service';
import { inject } from '@angular/core';
import * as TaskActions from '../../store/tasks/tasks.actions';
import { catchError, exhaustMap, map, of, tap } from 'rxjs';

export const loadTask$ = createEffect(
  (action$ = inject(Actions), taskApi = inject(TaskApiService)) => {
    return action$.pipe(
      ofType(TaskActions.loadTasks),
      exhaustMap(() => {
        return taskApi.getTasks().pipe(
          tap((tasks) => {
            console.log('tasks api', tasks);
          }),
          map((tasks) => TaskActions.loadTasksSuccess({ tasks })),
          catchError((error: Error) =>
            of(TaskActions.loadTasksFailure({ error: error.message })),
          ),
        );
      }),
    );
  },
  {
    functional: true,
  },
);
