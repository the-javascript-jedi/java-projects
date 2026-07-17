package com.learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        // Build SessionFactory — reads hibernate.cfg.xml and connects to DB
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        // Open a session — like opening a DB connection
        Session session = factory.openSession();

        // Begin transaction
        session.beginTransaction();

        // Create a new Student object and save it
        Student student = new Student("Nithin", 28, 95.0);
        session.persist(student); // INSERT INTO students

        // Commit transaction — actually saves to DB
        session.getTransaction().commit();

        System.out.println("Student saved: " + student);

        // Close session
        session.close();
        factory.close();
    }
}