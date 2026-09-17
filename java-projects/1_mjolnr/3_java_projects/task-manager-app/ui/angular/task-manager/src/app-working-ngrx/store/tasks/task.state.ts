import { Task, TaskStatus } from '../../core/models/task.model';

export type StatusFilter = 'All' | TaskStatus;

export interface TaskState {
  tasks: Task[];
  loading: boolean;
  error: string | null;
  searchTerm: string;
  statusFilter: StatusFilter;
}

export const initialTaskState: TaskState = {
  tasks: [],
  loading: false,
  error: null,
  searchTerm: '',
  statusFilter: 'All',
};
