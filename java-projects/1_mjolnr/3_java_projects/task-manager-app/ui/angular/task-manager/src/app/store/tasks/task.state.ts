import { Task, TaskStatus } from '../../core/models/task.model';

export type StatusFilter = 'All' | TaskStatus;

export interface TaskState {
  tasks: Task[];
  error: string | null;
  loading: boolean;
  searchTerm: string;
  searchFilter: StatusFilter;
}

export const initialTaskState: TaskState = {
  // tasks: [],
  tasks: [
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
  ],
  error: null,
  loading: false,
  searchTerm: '',
  searchFilter: 'All',
};
