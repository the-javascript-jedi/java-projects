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
  tasks: [],
  error: null,
  loading: false,
  searchTerm: '',
  searchFilter: 'All',
};
