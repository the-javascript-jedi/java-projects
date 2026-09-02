package com.learning.task_manager.task;

import com.learning.task_manager.dto.CreateTaskRequest;
import com.learning.task_manager.dto.TaskResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController tells Spring: this class handles HTTP requests and its methods
// return data (JSON) directly in the response body — not the name of a web page.
// Think of it like an Express router whose handlers automatically res.json(...) whatever you return.
@RestController
// @RequestMapping sets the base path for every route in this class.
// So all routes below start with "/tasks" (like app.use("/tasks", router) in Express).
@RequestMapping("/tasks")
public class TaskController {
    // @Autowired asks Spring to create and inject a TaskService instance for us
    // (dependency injection). You don't call `new TaskService()` — Spring hands one over.
    // Similar to passing a service into a constructor, but Spring wires it automatically.
    @Autowired
    private TaskService taskService;

    // @GetMapping with no path = GET /tasks
    // ResponseEntity<T> is the full HTTP response: status code + headers + body.
    // Here the body is a List<TaskResponse>, which Spring serializes to a JSON array.
    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAllTasks(){
        // .ok(...) builds a 200 OK response with the given body. Like res.status(200).json(list).
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    // GET /tasks/{id} — the {id} part is a URL placeholder (path parameter).
    // @PathVariable pulls that value out of the URL and into the `id` argument.
    // e.g. GET /tasks/5 -> id = 5. Like req.params.id in Express.
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTaskById(@PathVariable int id){
        TaskResponse task=taskService.getTaskById(id);
        // If the service found nothing, respond 404 Not Found (with an empty body).
        if(task==null) return ResponseEntity.notFound().build();
        // Otherwise 200 OK with the task as JSON.
        return ResponseEntity.ok(task);
    }

    // POST /tasks — create a new task.
    @PostMapping
    // @RequestBody deserializes the incoming JSON body into a CreateTaskRequest object.
    // @Valid triggers the validation rules declared on that DTO's fields; if the body
    // is invalid Spring rejects it with a 400 before this method even runs.
    // (Like a validation middleware running before your handler.)
    public ResponseEntity<TaskResponse> createTask(@Valid @RequestBody CreateTaskRequest request){
        TaskResponse task = taskService.createTask(request);
        // 201 CREATED is the conventional status for a successful resource creation.
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    // PUT /tasks/{id} — replace/update an existing task.
    // Takes both the id from the URL and the new data from the JSON body.
    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTask(@PathVariable int id,@Valid @RequestBody CreateTaskRequest request){
        TaskResponse updated=taskService.updateTask(id,request);
        return ResponseEntity.ok(updated);
    }

    // DELETE /tasks/{id} — remove a task.
    // ResponseEntity<Void> = there's no response body, just a status code.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable int id){
        taskService.deleteTask(id);
        // 204 No Content: success, and intentionally nothing to return.
        return ResponseEntity.noContent().build();
    }
}
