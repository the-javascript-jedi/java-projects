import { Component, signal } from '@angular/core';
import { Task } from '../../../core/models/task.model';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-task-dashboard',
  imports: [RouterLink],
  templateUrl: './task-dashboard.component.html',
  styleUrl: './task-dashboard.component.scss',
})
export class TaskDashboardComponent {
  readonly tasks = signal<Task[]>([
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
  ]);
}
