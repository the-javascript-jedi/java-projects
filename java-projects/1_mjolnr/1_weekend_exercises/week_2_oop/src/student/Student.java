/*
 * Problem: Student — Method Overloading Practice
 * Create a class representing a student, with two versions of a
 * describe() method that behave differently based on parameters.
 *
 * Fields: name (String), grade (int)
 *
 * Input:  Student student = new Student("Batman", 95);
 *         student.printDetails();
 *         student.describe();
 *         student.describe("science");
 * Output: Student: Batman| Grade: 95
 *         Student: Batman
 *         Student: Batman studies subject: science
 *
 * Approach: Store name and grade as private fields, expose via getters.
 * Define describe() twice with different parameter lists (method
 * overloading) — Java picks the correct version based on how many
 * arguments are passed at the call site.
 * Time complexity: O(1) for all operations
 */
package student;

public class Student {

    // Private fields — encapsulated, only accessible through getters
    private String name;
    private int grade;

    // Constructor — no access modifier means "package-private" (default access).
    // Works fine here since Main is in the same package, but public is more common.
    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for grade
    public int getGrade() {
        return grade;
    }

    // Prints full student details including grade
    public void printDetails() {
        System.out.println("Student: " + getName() + "| Grade: " + getGrade());
    }

    // Overloaded method #1 — no arguments, just prints the name
    public void describe() {
        System.out.println("Student: " + getName());
    }

    // Overloaded method #2 — same method name, but takes a String parameter.
    // Java tells these two apart by their parameter list (this is called
    // the method's "signature"), not by name alone.
    public void describe(String subject) {
        System.out.println("Student: " + getName() + " studies subject: " + subject);
    }

    // Entry point — creates a Student and calls all three methods
    public static void main(String args[]) {
        Student student = new Student("Batman", 95);
        student.printDetails();
        student.describe();          // calls the no-arg version
        student.describe("science"); // calls the String version
    }
}