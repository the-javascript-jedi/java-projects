package arraylist;

import java.util.ArrayList;

/*
 * Requirements:
 * - Create an ArrayList<String> of student names
 * - Add 5 names with add()
 * - Print the full list
 * - Remove one name by value
 * - Print the list again
 * - Loop through with a for loop and print each name with its index
 * - Print the total size with size()
 */
public class ArrayListDemo {

    public static void main(String args[]){

        // Create an ArrayList<String> of student names
        ArrayList<String> students=new ArrayList<>();

        // Add 5 names with add()
        students.add("Alice");
        students.add("Bob");
        students.add("Charlie");
        students.add("David");
        students.add("Emma");

        // Print the full list
        System.out.println("Student List:");
        System.out.println(students);

        // Remove one name by value
        students.remove("Charlie");

        // Print the list again
        System.out.println("\nAfter removing Charlie:");
        System.out.println(students);

        // Loop through with a for loop and print each name with its index
        System.out.println("\nStudents with index:");
        for(int i=0;i<students.size();i++){
            System.out.println(i+":"+students.get(i));
        }

        // Print the total size with size()
        System.out.println("\nTotal students: " + students.size());
    }
}

// O/P
//Student List:
//        [Alice, Bob, Charlie, David, Emma]
//
//        After removing Charlie:
//        [Alice, Bob, David, Emma]
//
//        Students with index:
//        0:Alice
//1:Bob
//2:David
//3:Emma
//
//        Total students: 4
