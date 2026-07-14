/*
* Create a Student class (inside the same file, not public) with:
Fields: String name, int grade
Constructor takes both
toString() — returns "Alice (95)"
Implements Comparable<Student> — sort by grade ascending
In main:
Create an ArrayList<Student> with 5 students, mixed grades
Print the list before sorting
Sort with Collections.sort() — uses Comparable
Print after sorting
Sort again by name alphabetically using a Comparator lambda
Print after that sort
Imports needed:
*
*
* */
package week5_exceptions.sorting;

import java.util.ArrayList;

public class SortingDemo {

    public static void main(String[] args){
        // Create an ArrayList<Student> with 5 students, mixed grades
        ArrayList<Student> students=new ArrayList<>();
        students.add(new Student("Alice", 95));
        students.add(new Student("Bob", 78));
        students.add(new Student("Charlie", 88));
        students.add(new Student("David", 72));
        students.add(new Student("Emma", 91));

        // Print the list before sorting
        System.out.println("Before sorting:");
        System.out.println(students);

        // list.sort() takes a Comparator — the lambda IS a Comparator<Student>,
        // Java infers this from sort()'s method signature.
        // (a, b) -> Integer.compare(a.grade, b.grade) returns negative when a's
        // grade is smaller, which tells sort() "a comes before b" -> ascending
        students.sort((a, b) -> Integer.compare(a.grade, b.grade));
        System.out.println("Grade Ascending:  " + students);

        // Swap a and b compared to ascending -> reverses the order -> descending
        students.sort((a, b) -> Integer.compare(b.grade, a.grade));
        System.out.println("Grade Descending:  " + students);

        System.out.println("\nSorted by name:");
        // String.compareTo() does alphabetical comparison: negative if a's name
        // comes before b's name alphabetically
        students.sort((a, b) -> a.name.compareTo(b.name));
        System.out.println("name ascending "+students);

        // Same trick as grade descending: swap a and b to reverse the order
        students.sort((a, b) -> b.name.compareTo(a.name));
        System.out.println("name descending "+students);
    }

    // Nested inside SortingDemo, not public (per requirements), static so it
    // can be instantiated from the static main() without needing an outer instance
    static class Student{
        String name;
        int grade;

        public Student(String name, int grade){
            this.name=name;
            this.grade=grade;
        }

        public String getName(){
            return this.name;
        }

        public int getGrade(){
            return this.grade;
        }

        // Controls how a Student prints, e.g. when println(students) prints the whole list
        @Override
        public String toString(){
            return getName()+"("+getGrade()+")";
        }
    }
}
//O/P
//Before sorting:[Alice(95), Bob(78), Charlie(88), David(72), Emma(91)]
//Grade Ascending:  [David(72), Bob(78), Charlie(88), Emma(91), Alice(95)]
//
//Grade Descending:  [Alice(95), Emma(91), Charlie(88), Bob(78), David(72)]
//
//Sorted by name:
//name ascending [Alice(95), Bob(78), Charlie(88), David(72), Emma(91)]
//name descending [Emma(91), David(72), Charlie(88), Bob(78), Alice(95)]