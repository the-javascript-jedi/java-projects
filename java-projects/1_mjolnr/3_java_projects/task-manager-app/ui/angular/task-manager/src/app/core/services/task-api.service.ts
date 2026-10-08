import { HttpClient } from '@angular/common/http';
import { inject } from '@angular/core';
import { Task } from '../models/task.model';
import { Observable } from 'rxjs';

export class TaskApiService {
  private readonly http = inject(HttpClient);

  private readonly baseUrl = '/api/tasks';

  getTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(this.baseUrl);
  }
}
