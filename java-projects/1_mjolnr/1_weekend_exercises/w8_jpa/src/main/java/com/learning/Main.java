package com.learning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // SessionFactory: built once per app, reads hibernate.cfg.xml (DB url/user/password,
        // dialect, etc.) and knows how to open connections/sessions. Expensive to create,
        // so normally you'd keep one instance around rather than rebuilding it each time.
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        // Session: a single unit-of-work / DB connection wrapper (like a JDBC Connection,
        // but object-aware). beginTransaction() starts a DB transaction that all the
        // CRUD calls below run inside of, until commit() at the bottom.
        Session session = factory.openSession();
        session.beginTransaction();

        // CREATE — save a new student
        Student newStudent = new Student("John", 25, 88.0);
        session.persist(newStudent);
        System.out.println("Saved: " + newStudent);

        // READ — find by id
        Student found = session.get(Student.class, 7); // get Nithin (id=7)
        System.out.println("Found: " + found);

        // READ ALL — get every student
        List<Student> allStudents = session.createQuery("FROM Student", Student.class).list();
        System.out.println("All students:");
        allStudents.forEach(s -> System.out.println(s));

        // UPDATE — change Nithin's grade
        found.setGrade(99.0); // just update the object — Hibernate detects the change
        System.out.println("Updated: " + found);

        // DELETE — remove John
        session.remove(newStudent);
        System.out.println("Deleted John");

        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}