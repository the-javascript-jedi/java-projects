package com.courses;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CourseMain {
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

        // CREATE — save a new course
        Courses newCourse = new Courses(6, "Java MJOLNR program", "Claude");
        session.persist(newCourse);
        System.out.println("Saved: " + newCourse);

        // READ — find by id
        Courses found = session.get(Courses.class, 8);
        System.out.println("Found: " + found);

        // READ ALL — get every course
        List<Courses> allCourses = session.createQuery("FROM Courses", Courses.class).list();
        System.out.println("All Courses:");
        allCourses.forEach(s -> System.out.println(s));

        // UPDATE — change the instructor
        found.setInstructor("Mrs Black"); // just update the object — Hibernate detects the change
        System.out.println("Updated: " + found);

        // DELETE — remove the course
        session.remove(found);
        System.out.println("Deleted course");

        session.getTransaction().commit();
        session.close();
        factory.close();
    }
}

