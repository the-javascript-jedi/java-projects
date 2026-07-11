package queue;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Requirements:
 * - Create a Queue<String> of customer names
 * - Add 4 customers with add()
 * - Print the full queue
 * - Peek at the front with peek() — print who's next without removing
 * - Serve (remove) customers one by one with poll() — print each one as "Serving: Alice"
 * - Print the queue after each poll()
 * - Print size at the end
 */
public class QueueDemo {
    public static void main(String[] args){
        // Queue is an interface, so it needs a concrete implementation like LinkedList
        Queue<String> customers = new LinkedList<>();

        // Add 4 customers with add()
        customers.add("Alice");
        customers.add("Bob");
        customers.add("Charlie");
        customers.add("David");

        // Print the full queue
        System.out.println("Full queue: " + customers);

        // Peek at the front with peek() — this does NOT remove the customer
        System.out.println("Next customer: " + customers.peek());

        // Serve (remove) customers one by one with poll()
        while (!customers.isEmpty()) {
            String customer = customers.poll();
            System.out.println("Serving: " + customer);

            // Print the queue after each poll()
            System.out.println("Queue now: " + customers);
        }

        // Print size at the end (0, since all customers were served)
        System.out.println("Final queue size: " + customers.size());

    }
}

//O/P
//        Full queue: [Alice, Bob, Charlie, David]
//        Next customer: Alice
//        Serving: Alice
//        Queue now: [Bob, Charlie, David]
//        Serving: Bob
//        Queue now: [Charlie, David]
//        Serving: Charlie
//        Queue now: [David]
//        Serving: David
//        Queue now: []
//        Final queue size: 0

