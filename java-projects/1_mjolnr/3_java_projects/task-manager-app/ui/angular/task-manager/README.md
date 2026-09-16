Architecture
task-manager-ui/
├── src/
│ ├── app/
│ │ ├── core/ # App-wide, singleton concerns
│ │ │ ├── models/
│ │ │ │ └── task.model.ts # Task, TaskStatus, request types
│ │ │ ├── services/
│ │ │ │ └── task-api.service.ts # HttpClient calls to Spring API
│ │ │ └── interceptors/ # Later: central HTTP error handling
│ │ │
│ │ ├── store/ # Global NgRx state
│ │ │ └── tasks/
│ │ │ ├── tasks.actions.ts # load/create/update/delete actions
│ │ │ ├── tasks.reducer.ts # Immutable task state updates
│ │ │ ├── tasks.effects.ts # RxJS API calls
│ │ │ ├── tasks.selectors.ts # Read tasks/loading/errors
│ │ │ └── tasks.state.ts # TaskState initial state
│ │ │
│ │ ├── features/ # Screens grouped by business feature
│ │ │ └── tasks/
│ │ │ ├── task-dashboard/ # `/tasks`: list, search, filters
│ │ │ ├── task-form/ # `/tasks/new` and `/tasks/:id/edit`
│ │ │ └── task-details/ # `/tasks/:id`
│ │ │
│ │ ├── shared/ # Reusable presentation components
│ │ │ ├── task-card/
│ │ │ ├── status-badge/
│ │ │ ├── delete-task-dialog/
│ │ │ └── empty-state/
│ │ │
│ │ ├── app.component.ts # Root shell/header/router outlet
│ │ ├── app.config.ts # Router, HTTP, NgRx providers
│ │ └── app.routes.ts # Route definitions
│ │
│ ├── styles.scss # Global colours, typography, resets
│ └── main.ts
│
└── package.json

===============================================================================================
Task Form
→ dispatch(createTask({ task }))
→ NgRx Effect calls POST /tasks
→ dispatch(createTaskSuccess({ task }))
→ Reducer adds task to state
→ Router navigates to /tasks
→ Dashboard updates automatically via selector signal
================================================================================================

For now, build in this order:

1. core/models/task.model.ts
2. Routes and empty screen components
3. Dashboard layout with mock task cards
4. Reusable task form UI
5. NgRx state using mock data
6. Replace mock data with TaskApiService and effects
   This keeps the UI visible quickly while still teaching the proper API/state-management structure.

=================================================================================================
ng new task-manager --standalone --routing --style=scss --ssr=false

npm install @ngrx/store@19 @ngrx/effects@19 @ngrx/store-devtools@19

ng serve --open

ng generate component features/tasks/task-dashboard --standalone
ng generate component features/tasks/task-form --standalone
ng generate component features/tasks/task-details --standalone
ng generate component shared/delete-task-dialog --standalone
