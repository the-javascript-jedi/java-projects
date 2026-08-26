package com.learning.task_manager.task;

import jakarta.persistence.*;

//@Entity — "this class maps to a DB table"
@Entity
//@Table(name="tasks") — "the table is called tasks"
@Table(name="tasks")
public class Task {
//    @Id + @GeneratedValue — "id is the primary key, auto increment"
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    @Column — "each field maps to a column"
    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;
//    @Enumerated(EnumType.STRING) — "store status as text not number"
    @Enumerated(EnumType.STRING) // store as "TODO"/"IN_PROGRESS"/"DONE" in DB
    @Column(name="status")
    private TaskStatus status;

    @Column(name="dueDate")
    private String dueDate;

    //Default constructor — Hibernate requires it
    public Task() {}

    public Task(String title,String description, String dueDate){
        this.title=title;
        this.description=description;
        this.dueDate=dueDate;
    }

    public int getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public String getDueDate(){
        return dueDate;
    }

    public TaskStatus getStatus() { return status; }

    public void setTitle(String title){
        this.title=title;
    }
    public void setStatus(TaskStatus status) { this.status = status; }

    public void setDescription(String description){
        this.description=description;
    }

    public void setDueDate(String dueDate){
        this.dueDate=dueDate;
    }

    @Override
    public String toString() {
        return "Task{id=" + id + ", title=" + title + ", status=" + status + ", dueDate=" + dueDate + "}";
    }

}







