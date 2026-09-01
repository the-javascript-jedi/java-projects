package com.learning.task_manager.task;

import com.learning.task_manager.dto.CreateTaskRequest;
import com.learning.task_manager.dto.TaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// Service layer: holds the business logic between the Controller (HTTP layer)
// and the Repository (DB layer). Think of it like an Express "service"/"controller
// helper" module that a route handler calls into, instead of talking to the DB directly.
//
// Flow for each method:
//   getAllTasks()  -> fetch all rows -> convert each to a DTO -> return list
//   getTaskById()  -> fetch one row  -> convert to DTO
//   createTask()   -> build entity   -> save -> convert to DTO
//   updateTask()   -> fetch entity   -> mutate fields -> save -> convert to DTO
//   deleteTask()   -> fetch (to confirm it exists) -> delete

@Service // tells Spring to create one shared instance of this class (a "singleton bean")
         // and make it injectable elsewhere, similar to registering a service in a DI container
public class TaskService {

    @Autowired // Spring automatically injects (constructs/finds) the TaskRepository instance here.
               // Similar to dependency injection in Angular, but done via annotation instead of constructor args.
    private TaskRepository taskRepository;

    // Task (entity) = the DB-shaped object, annotated with JPA (@Entity etc.), mirrors the "tasks" table.
    // TaskResponse (DTO) = the API-shaped object we actually send back as JSON.
    // Unlike JS where you might just `res.json(dbRow)`, Java has no implicit conversion between
    // two different classes, so toDto() manually copies the fields we want to expose over the wire.
    private TaskResponse toDto(Task task){
        return new TaskResponse(task.getId(),task.getTitle(),task.getStatus(),task.getDueDate());
    }

    // Fetch every Task row, then map() each one through toDto(), same idea as
    // `tasks.map(toDto)` in JS. Collectors.toList() is just the Java way of turning
    // a Stream back into a List (like calling .map() on an array already gives you an array).
    // SQL: SELECT * FROM tasks;
    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    // findById returns an Optional<Task> (Java's version of "value or null/undefined").
    // orElseThrow() says: if empty, throw this exception instead of returning null.
    // SQL: SELECT * FROM tasks WHERE id = ?;
    public TaskResponse getTaskById(int taskId){
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        return toDto(task);
    }

    // Build a new Task entity from the incoming request DTO, persist it (save() does
    // an INSERT since it has no id yet), then convert the saved entity back to a DTO.
    // SQL: INSERT INTO tasks (title, description, status, dueDate) VALUES (?, ?, ?, ?);
    public TaskResponse createTask(CreateTaskRequest request){
        Task task = new Task(request.getTitle(), request.getDescription(), request.getDueDate());
        return toDto(taskRepository.save(task));
    }

    // Load the existing row, overwrite its fields with the new values, then save().
    // Because `existing` already has an id, save() here does an UPDATE, not an INSERT.
    // SQL: SELECT * FROM tasks WHERE id = ?;
    //      UPDATE tasks SET title = ?, description = ?, status = ?, dueDate = ? WHERE id = ?;
    public TaskResponse updateTask(int id, CreateTaskRequest request){
        Task existing=taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        existing.setTitle(request.getTitle());
        existing.setDescription(request.getDescription());
        existing.setStatus(request.getStatus());
        existing.setDueDate(request.getDueDate());
        return toDto(taskRepository.save(existing));
    }

    // Check the row exists first (so we can throw a clear "not found" error),
    // then actually delete it by id.
    // SQL: SELECT * FROM tasks WHERE id = ?;
    //      DELETE FROM tasks WHERE id = ?;
    public void deleteTask(int id){
        taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        taskRepository.deleteById(id);
    }
}
