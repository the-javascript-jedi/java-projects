import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Task } from '../models/task.model';

@Injectable({ providedIn: 'root' })
export class TaskApiService {
  private readonly http = inject(HttpClient);
  // "/api" is forwarded to the Spring Boot server (localhost:8080) by proxy.conf.json,
  // which also strips the prefix — so this hits GET http://localhost:8080/tasks.
  private readonly baseUrl = '/api/tasks';

  getTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(this.baseUrl);
  }
}
