import { Component, input, output } from '@angular/core';

// "Dumb" component: knows nothing about the store. The parent decides
// what happens on confirm/cancel — like a React component with onConfirm/onCancel props.
@Component({
  selector: 'app-delete-task-dialog',
  imports: [],
  templateUrl: './delete-task-dialog.component.html',
  styleUrl: './delete-task-dialog.component.scss',
})
export class DeleteTaskDialogComponent {
  readonly taskTitle = input.required<string>();
  readonly confirmed = output<void>();
  readonly cancelled = output<void>();
}
