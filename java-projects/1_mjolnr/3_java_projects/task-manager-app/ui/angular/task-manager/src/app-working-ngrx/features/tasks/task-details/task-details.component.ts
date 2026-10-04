import { Component, inject } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { Store } from '@ngrx/store';
import { selectTaskById } from '../../../store/tasks/tasks.selectors';

@Component({
  selector: 'app-task-details',
  imports: [RouterLink, DatePipe],
  templateUrl: './task-details.component.html',
  styleUrl: './task-details.component.scss',
})
export class TaskDetailsComponent {
  private readonly route = inject(ActivatedRoute);
  private readonly store = inject(Store);

  // Route params are always strings, so convert '2' -> 2 to match Task.id.
  readonly taskId = Number(this.route.snapshot.paramMap.get('id'));

  // undefined when no task has this id (bad URL, or tasks not loaded yet).
  readonly task = this.store.selectSignal(selectTaskById(this.taskId));
}
