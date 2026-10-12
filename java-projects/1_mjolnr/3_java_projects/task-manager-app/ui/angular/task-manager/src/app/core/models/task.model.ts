export type TaskStatus = 'TODO' | 'IN_PROGRESS' | 'DONE';

export interface Task {
  id: number;
  title: string;
  description: string;
  dueDate: string;
  status: TaskStatus;
}

// Request body for POST/PUT — matches CreateTaskRequest in the Java backend (no id).
export type TaskInput = Omit<Task, 'id'>;
