package hashmap;

import java.util.HashMap;
import java.util.Map;

/*
 * Requirements:
 * - Create a HashMap<String, Integer> of student names and their scores
 * - Add 5 students with put()
 * - Print the full map
 * - Get one student's score with get()
 * - Update a score with put() again (same key, new value)
 * - Remove one student with remove()
 * - Loop through all entries and print "Alice: 95"
 * - Check if a key exists with containsKey()
 */
public class HashMapDemo {

    public static void main(String[] args){
        // Create a HashMap<String, Integer> of student names and their scores
        HashMap<String,Integer> students=new HashMap<>();

        // Add 5 students with put()
        students.put("Alice", 95);
        students.put("Bob", 88);
        students.put("Charlie", 92);
        students.put("David", 85);
        students.put("Emma", 90);

        // Print the full map
        System.out.println("Student Scores:");
        System.out.println(students);

        // Get one student's score with get()
        System.out.println("\nAlice's score: " + students.get("Alice"));

        // Update a score with put() again (same key, new value)
        students.put("Alice", 97);
        System.out.println("Alice's updated score: " + students.get("Alice"));

        // Remove one student with remove()
        students.remove("David");

        System.out.println("\nAfter removing David:");
        System.out.println(students);

        // Loop through all entries and print "Alice: 95"
        System.out.println("\nStudent Scores:");
        for (Map.Entry<String, Integer> entry : students.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Check if a key exists with containsKey()
        System.out.println("\nContains Emma? " + students.containsKey("Emma"));
    }
}
// O/P
//Student Scores:
//        {Bob=88, Alice=95, Charlie=92, David=85, Emma=90}
//
//        Alice's score: 95
//        Alice's updated score: 97
//
//        After removing David:
//        {Bob=88, Alice=97, Charlie=92, Emma=90}
//
//        Student Scores:
//        Bob: 88
//        Alice: 97
//        Charlie: 92
//        Emma: 90
//
//        Contains Emma? true