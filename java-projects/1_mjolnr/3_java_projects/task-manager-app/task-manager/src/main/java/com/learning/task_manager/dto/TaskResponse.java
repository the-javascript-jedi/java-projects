package com.learning.task_manager.dto;

import com.learning.task_manager.task.TaskStatus;

// DTO (Data Transfer Object): shapes the JSON sent back to the client.
// Like a JS "response shape" you'd build with `{ id, title, status, dueDate }`,
// but Java needs a real class with typed fields instead of a plain object literal.
// Keeping this separate from the Task entity means internal DB fields
// (e.g. things you don't want exposed) never leak into the API response.
public class TaskResponse {
    private int id;
    private String title;
    private TaskStatus status;
    private String dueDate;

    // No-arg constructor: some frameworks (Jackson, JPA, etc.) need this
    // to create an "empty" instance before filling in fields via setters/reflection.
    public TaskResponse(){}

    // Main constructor used to build a fully-populated response object,
    // e.g. `new TaskResponse(task.getId(), task.getTitle(), ...)`.
    public TaskResponse(int id, String title, TaskStatus status, String dueDate){
        this.id=id;
        this.title=title;
        this.status=status;
        this.dueDate=dueDate;
    }

    // Getters below: Java has no shorthand property access like `task.id` in JS/TS
    // for encapsulated fields, so each private field needs an explicit getter.
    // Jackson (Spring's default JSON library) calls these to serialize the object to JSON.
//    Spring uses getter names to serialize to JSON — without get prefix the fields won't appear in the API response.
    public int getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public TaskStatus getStatus(){
        return this.status;
    }

    public String getDueDate(){
        return this.dueDate;
    }

}
