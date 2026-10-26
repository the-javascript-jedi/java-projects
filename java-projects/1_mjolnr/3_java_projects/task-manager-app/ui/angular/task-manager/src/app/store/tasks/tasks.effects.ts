import { Actions, createEffect, ofType } from '@ngrx/effects';
import { TaskApiService } from '../../core/services/task-api.service';
import { inject } from '@angular/core';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import * as TaskActions from '../../store/tasks/tasks.actions';
import {
  catchError,
  concatMap,
  exhaustMap,
  map,
  mergeMap,
  of,
  switchMap,
  tap,
} from 'rxjs';

// Prefer the message from Spring's GlobalExceptionHandler ({ error: "..." } or
// { field: "message" } for validation), fall back to Angular's generic message.
function toErrorMessage(error: HttpErrorResponse): string {
  const body = error.error;
  if (body && typeof body === 'object') {
    return Object.values(body).join(', ');
  }
  return error.message;
}

// ---- API effects -------------------------------------------------------
// catchError sits INSIDE the inner pipe so one failed request doesn't
// kill the effect stream for every future dispatch.

// exhaustMap: ignore new "load" clicks while one load is still in flight.
export const loadTasks$ = createEffect(
  (action$ = inject(Actions), taskApi = inject(TaskApiService)) => {
    return action$.pipe(
      ofType(TaskActions.loadTasks),
      exhaustMap(() =>
        taskApi.getTasks().pipe(
          tap((tasks) => console.log('tasks api', tasks)),
          map((tasks) => TaskActions.loadTasksSuccess({ tasks })),
          catchError((error: HttpErrorResponse) =>
            of(TaskActions.loadTasksFailure({ error: toErrorMessage(error) })),
          ),
        ),
      ),
    );
  },
  { functional: true },
);

// switchMap: if the user jumps to another task, cancel the old request.
export const loadTask$ = createEffect(
  (action$ = inject(Actions), taskApi = inject(TaskApiService)) => {
    return action$.pipe(
      ofType(TaskActions.loadTask),
      switchMap(({ id }) =>
        taskApi.getTask(id).pipe(
          map((task) => TaskActions.loadTaskSuccess({ task })),
          catchError((error: HttpErrorResponse) =>
            of(TaskActions.loadTaskFailure({ error: toErrorMessage(error) })),
          ),
        ),
      ),
    );
  },
  { functional: true },
);

// concatMap for writes: run them one after another, never drop or cancel a save.
export const addTask$ = createEffect(
  (action$ = inject(Actions), taskApi = inject(TaskApiService)) => {
    return action$.pipe(
      ofType(TaskActions.addTask),
      concatMap(({ task }) =>
        taskApi.createTask(task).pipe(
          map((saved) => TaskActions.addTaskSuccess({ task: saved })),
          catchError((error: HttpErrorResponse) =>
            of(TaskActions.addTaskFailure({ error: toErrorMessage(error) })),
          ),
        ),
      ),
    );
  },
  { functional: true },
);

export const updateTask$ = createEffect(
  (action$ = inject(Actions), taskApi = inject(TaskApiService)) => {
    return action$.pipe(
      ofType(TaskActions.updateTask),
      concatMap(({ task }) => {
        const { id, ...body } = task; // id goes in the URL, the rest in the body
        return taskApi.updateTask(id, body).pipe(
          map((saved) => TaskActions.updateTaskSuccess({ task: saved })),
          catchError((error: HttpErrorResponse) =>
            of(TaskActions.updateTaskFailure({ error: toErrorMessage(error) })),
          ),
        );
      }),
    );
  },
  { functional: true },
);

// mergeMap: deletes of different tasks are independent, run them in parallel.
export const deleteTask$ = createEffect(
  (action$ = inject(Actions), taskApi = inject(TaskApiService)) => {
    return action$.pipe(
      ofType(TaskActions.deleteTask),
      mergeMap(({ id }) =>
        taskApi.deleteTask(id).pipe(
          map(() => TaskActions.deleteTaskSuccess({ id })),
          catchError((error: HttpErrorResponse) =>
            of(TaskActions.deleteTaskFailure({ error: toErrorMessage(error) })),
          ),
        ),
      ),
    );
  },
  { functional: true },
);

// ---- Navigation effects ------------------------------------------------
// Only navigate once the server confirmed the change. dispatch: false because
// these effects don't emit a new action, they just cause a side effect.

export const navigateAfterSave$ = createEffect(
  (action$ = inject(Actions), router = inject(Router)) => {
    return action$.pipe(
      ofType(TaskActions.addTaskSuccess, TaskActions.updateTaskSuccess),
      tap(({ task }) => router.navigate(['/tasks', task.id])),
    );
  },
  { functional: true, dispatch: false },
);

export const navigateAfterDelete$ = createEffect(
  (action$ = inject(Actions), router = inject(Router)) => {
    return action$.pipe(
      ofType(TaskActions.deleteTaskSuccess),
      tap(() => router.navigate(['/tasks'])),
    );
  },
  { functional: true, dispatch: false },
);
