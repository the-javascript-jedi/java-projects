import { Routes } from '@angular/router';
import { TaskDashboardComponent } from './features/tasks/task-dashboard/task-dashboard.component';
import { TaskFormComponent } from './features/tasks/task-form/task-form.component';
import { TaskDetailsComponent } from './features/tasks/task-details/task-details.component';

export const routes: Routes = [
  {
    path: 'tasks',
    component: TaskDashboardComponent,
    title: 'My Tasks | Taskflow',
  },
  {
    path: 'tasks/new',
    component: TaskFormComponent,
    title: 'Create Task | Taskflow',
  },
  {
    path: 'tasks/:id',
    component: TaskDetailsComponent,
    title: 'Task Details | TaskFlow',
  },
  {
    path: 'tasks/:id/edit',
    component: TaskFormComponent,
    title: 'Edit Task | TaskFlow',
  },
  // Default route: when the user opens http://localhost:4200/ with no path,
  // redirect them to the task dashboard at /tasks.
  // `pathMatch: 'full'` prevents this empty path from matching every URL.
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'tasks',
  },
  // Wildcard/fallback route: catches any URL that did not match a route above.
  // Keep this last because `**` matches everything.
  // It sends users back to the dashboard instead of showing a blank page.
  {
    path: '**',
    redirectTo: 'tasks',
  },
];
