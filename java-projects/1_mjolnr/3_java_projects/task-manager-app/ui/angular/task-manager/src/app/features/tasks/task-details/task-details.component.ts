import { Component, effect, inject, signal } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Store } from '@ngrx/store';
import {
  selectError,
  selectLoading,
  selectTaskById,
} from '../../../store/tasks/tasks.selectors';
import { deleteTask, loadTask } from '../../../store/tasks/tasks.actions';
import { DatePipe } from '@angular/common';
import { RouterLink } from '@angular/router';
import { DeleteTaskDialogComponent } from '../../../shared/delete-task-dialog/delete-task-dialog.component';

@Component({
  selector: 'app-task-details',
  imports: [DatePipe, RouterLink, DeleteTaskDialogComponent],
  templateUrl: './task-details.component.html',
  styleUrl: './task-details.component.scss',
})
export class TaskDetailsComponent {
  private route = inject(ActivatedRoute);
  private store = inject(Store);
  readonly taskId = Number(this.route.snapshot.paramMap.get('id'));

  // undefined when no task has this id (bad URL, or still loading).
  readonly task = this.store.selectSignal(selectTaskById(this.taskId));
  readonly loading = this.store.selectSignal(selectLoading);
  readonly error = this.store.selectSignal(selectError);

  // Local UI state only — whether the confirm dialog is open doesn't belong in the store.
  readonly showDeleteDialog = signal(false);

  constructor() {
    // Fetch from the API so /tasks/:id also works after a page refresh.
    this.store.dispatch(loadTask({ id: this.taskId }));

    effect(() => {
      console.log('task', this.task());
    });
  }

  confirmDelete(): void {
    this.showDeleteDialog.set(false);
    // navigateAfterDelete$ takes us back to /tasks once the server confirms.
    this.store.dispatch(deleteTask({ id: this.taskId }));
  }
}
