import { Component, computed, effect, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { Store } from '@ngrx/store';
import { TaskStatus } from '../../../core/models/task.model';
import { selectTaskById } from '../../../store/tasks/tasks.selectors';
import { addTask, updateTask } from '../../../store/tasks/tasks.actions';

@Component({
  selector: 'app-task-form',
  imports: [ReactiveFormsModule, RouterLink],
  templateUrl: './task-form.component.html',
  styleUrl: './task-form.component.scss',
})
export class TaskFormComponent {
  private readonly route = inject(ActivatedRoute);
  private readonly router = inject(Router);
  private readonly store = inject(Store);
  private readonly fb = inject(FormBuilder);

  // /tasks/new -> no :id param (null). /tasks/1/edit -> '1'.
  private readonly idParam = this.route.snapshot.paramMap.get('id');
  readonly taskId = this.idParam ? Number(this.idParam) : null;
  readonly isEditMode = this.taskId !== null;

  // In create mode there's no task to look up; id -1 never matches, so this is undefined.
  readonly task = this.store.selectSignal(selectTaskById(this.taskId ?? -1));
  readonly notFound = computed(() => this.isEditMode && !this.task());

  readonly statuses: { value: TaskStatus; label: string }[] = [
    { value: 'TODO', label: 'To do' },
    { value: 'IN_PROGRESS', label: 'In progress' },
    { value: 'DONE', label: 'Done' },
  ];

  // nonNullable: form.reset() goes back to these defaults instead of null.
  readonly form = this.fb.nonNullable.group({
    title: ['', [Validators.required, Validators.maxLength(100)]],
    description: [''],
    dueDate: ['', Validators.required],
    status: ['TODO' as TaskStatus, Validators.required],
  });

  constructor() {
    // Fill the form once the task is in the store. Use an effect (not a
    // one-time patch) because the task may arrive after this component is
    // created. The `pristine` check makes sure the user's typing is never
    // overwritten.
    effect(() => {
      const task = this.task();
      if (task && this.form.pristine) {
        this.form.patchValue(task);
      }
    });
  }

  // Short helper so the template can say hasError('title').
  hasError(control: 'title' | 'dueDate'): boolean {
    const c = this.form.controls[control];
    return c.invalid && (c.touched || c.dirty);
  }

  onSubmit(): void {
    if (this.form.invalid) {
      this.form.markAllAsTouched(); // shows every error message at once
      return;
    }

    const values = this.form.getRawValue();

    if (this.isEditMode && this.taskId !== null) {
      this.store.dispatch(updateTask({ task: { id: this.taskId, ...values } }));
      this.router.navigate(['/tasks', this.taskId]);
    } else {
      this.store.dispatch(addTask({ task: values }));
      this.router.navigate(['/tasks']);
    }
  }
}
