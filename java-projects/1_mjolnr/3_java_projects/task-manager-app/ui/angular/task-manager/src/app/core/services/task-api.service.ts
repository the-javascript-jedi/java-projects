import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Task, TaskInput } from '../models/task.model';
import { Observable } from 'rxjs';

// One method per Spring endpoint in TaskController.
// '/api' is stripped by proxy.conf.json, so '/api/tasks' -> http://localhost:8080/tasks.
@Injectable({ providedIn: 'root' })
export class TaskApiService {
  private readonly http = inject(HttpClient);

  private readonly baseUrl = '/api/tasks';

  // GET /tasks
  getTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(this.baseUrl);
  }

  // GET /tasks/{id}
  getTask(id: number): Observable<Task> {
    return this.http.get<Task>(`${this.baseUrl}/${id}`);
  }

  // POST /tasks -> 201 with the saved task (including the DB-generated id)
  createTask(task: TaskInput): Observable<Task> {
    return this.http.post<Task>(this.baseUrl, task);
  }

  // PUT /tasks/{id} -> 200 with the updated task
  updateTask(id: number, task: TaskInput): Observable<Task> {
    return this.http.put<Task>(`${this.baseUrl}/${id}`, task);
  }

  // DELETE /tasks/{id} -> 204 No Content
  deleteTask(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
