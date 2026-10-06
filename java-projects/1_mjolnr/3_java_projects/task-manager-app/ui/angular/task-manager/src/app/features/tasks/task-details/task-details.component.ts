import { Component, effect, inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Store } from '@ngrx/store';
import { selectTaskById } from '../../../store/tasks/tasks.selectors';

@Component({
  selector: 'app-task-details',
  imports: [],
  templateUrl: './task-details.component.html',
  styleUrl: './task-details.component.scss',
})
export class TaskDetailsComponent {
  private route = inject(ActivatedRoute);
  private store = inject(Store);
  readonly taskId = Number(this.route.snapshot.paramMap.get('id'));
  constructor() {
    effect(() => {
      console.log('task', this.task());
    });
  }

  // undefined when no task has this id (bad URL, or tasks not loaded yet).
  readonly task = this.store.selectSignal(selectTaskById(this.taskId));
}
