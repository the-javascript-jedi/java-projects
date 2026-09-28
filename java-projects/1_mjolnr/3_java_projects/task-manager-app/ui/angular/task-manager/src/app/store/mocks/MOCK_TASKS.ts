import { Task } from '../../core/models/task.model';

export const initialTasks: Task[] = [
  {
    id: 1,
    title: 'Learn NgRx',
    description: 'Actions, reducers, selectors',
    dueDate: '2026-10-01',
    status: 'IN_PROGRESS',
  },
  {
    id: 2,
    title: 'Build API',
    description: 'Spring Boot task controller',
    dueDate: '2026-10-05',
    status: 'TODO',
  },
  {
    id: 3,
    title: 'Setup project',
    description: 'Angular + NgRx install',
    dueDate: '2026-09-20',
    status: 'DONE',
  },
];
