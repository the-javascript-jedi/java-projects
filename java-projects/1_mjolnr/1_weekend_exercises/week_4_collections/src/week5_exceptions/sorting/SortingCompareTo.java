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
import java.util.Collections;

public class SortingCompareTo {

    public static void main(String[] args){
        // Create an ArrayList<Student> with 5 students, mixed grades
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 95));
        students.add(new Student("Bob", 78));
        students.add(new Student("Charlie", 88));
        students.add(new Student("David", 72));
        students.add(new Student("Emma", 91));

        // Print the list before sorting
        System.out.println("Before sorting:");
        System.out.println(students);

        // Sort with Collections.sort() — uses Comparable's compareTo()
        // No lambda needed here since Student already defines its natural order (grade ascending)
        Collections.sort(students);
        System.out.println("\nGrade ascending (Comparable):");
        System.out.println(students);

        // Collections.reverseOrder() wraps compareTo() and flips its result,
        // so this still goes through the natural order, just reversed
        Collections.sort(students, Collections.reverseOrder());
        System.out.println("\nGrade descending (reverseOrder wraps Comparable):");
        System.out.println(students);

        // Sort by name alphabetically using a Comparator lambda
        Collections.sort(students, (a, b) -> a.getName().compareTo(b.getName()));
        System.out.println("\nName ascending (Comparator):");
        System.out.println(students);

        // Swap a and b to reverse the alphabetical comparison
        Collections.sort(students, (a, b) -> b.getName().compareTo(a.getName()));
        System.out.println("\nName descending (Comparator):");
        System.out.println(students);
    }

    // Nested inside SortingCompareTo, not public, static so it can be used
    // from the static main() without needing an outer instance
    static class Student implements Comparable<Student>{
        String name;
        int grade;

        public Student(String name, int grade){
            this.name = name;
            this.grade = grade;
        }

        public String getName(){
            return this.name;
        }

        public int getGrade(){
            return this.grade;
        }

        @Override
        public String toString(){
            return getName()+" ("+getGrade()+")";
        }

        // Defines Student's natural order: ascending by grade.
        // Collections.sort(students) uses this automatically since Student implements Comparable
        @Override
        public int compareTo(Student other){
            return Integer.compare(this.grade, other.grade);
        }
    }
}

//OP
//Before sorting:
//        [Alice (95), Bob (78), Charlie (88), David (72), Emma (91)]
//
//Grade ascending (Comparable):
//        [David (72), Bob (78), Charlie (88), Emma (91), Alice (95)]
//
//Grade descending (reverseOrder wraps Comparable):
//        [Alice (95), Emma (91), Charlie (88), Bob (78), David (72)]
//
//Name ascending (Comparator):
//        [Alice (95), Bob (78), Charlie (88), David (72), Emma (91)]
//
//Name descending (Comparator):
//        [Emma (91), David (72), Charlie (88), Bob (78), Alice (95)]