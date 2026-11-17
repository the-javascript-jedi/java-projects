package com.learning.movie_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication = the "start here" marker. It combines three things:
//  1. @Configuration         -> this class can define Spring settings
//  2. @EnableAutoConfiguration -> Spring guesses and configures things from the libraries you added
//     (sees MySQL + JPA + web in pom.xml, so it sets up the DB connection and the web server for you)
//  3. @ComponentScan         -> Spring scans THIS package and everything under it (com.learning.movie_manager.*)
//     looking for @RestController, @Service, @Repository, @Entity classes and registers them.
// That is why every other class must live inside com.learning.movie_manager (or a sub-package).
@SpringBootApplication
public class MovieManagerApplication {

	// main = the entry point Java runs first (like index.js / "node server.js").
	public static void main(String[] args) {
		// Boots Spring: starts the embedded Tomcat web server (port 8080 by default),
		// connects to MySQL, creates the beans, and begins listening for HTTP requests.
		SpringApplication.run(MovieManagerApplication.class, args);
	}

}
