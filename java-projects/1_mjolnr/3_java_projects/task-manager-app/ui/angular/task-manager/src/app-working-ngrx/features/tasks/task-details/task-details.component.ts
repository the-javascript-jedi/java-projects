import { Component, inject } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';

@Component({
  selector: 'app-task-details',
  imports: [RouterLink],
  templateUrl: './task-details.component.html',
  styleUrl: './task-details.component.scss',
})
export class TaskDetailsComponent {
  private readonly route = inject(ActivatedRoute);
  readonly taskId = this.route.snapshot.paramMap.get('id');
}
