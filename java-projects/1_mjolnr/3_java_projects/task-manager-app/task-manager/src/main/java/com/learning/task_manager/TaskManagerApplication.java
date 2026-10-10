package com.learning.task_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Entry point of the backend — like the `index.js` you'd run with `node index.js`.
// @SpringBootApplication turns on auto-configuration and component scanning:
// Spring looks through this package and its sub-packages (task, dto, exception)
// for @RestController, @Service, @Entity etc. and wires them together.
// That's why this class must sit in the top-level package, above those folders.
@SpringBootApplication
public class TaskManagerApplication {

    // Java always starts a program at a `public static void main` method.
    // SpringApplication.run boots the embedded web server (Tomcat, port 8080 by default),
    // similar to app.listen(8080) in Express.
    public static void main(String[] args) {
        SpringApplication.run(TaskManagerApplication.class, args);
    }
}
