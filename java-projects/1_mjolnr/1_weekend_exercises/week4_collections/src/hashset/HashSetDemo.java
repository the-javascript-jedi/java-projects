package hashset;

import java.util.HashSet;

/*
 * Requirements:
 * - Create a HashSet<String> of city names
 * - Add 5 cities with add() — add one city twice and see what happens
 * - Print the full set
 * - Remove one city with remove()
 * - Check if a city exists with contains()
 * - Loop through and print each city
 * - Print the size with size()
 */
public class HashSetDemo {
    public static void main(String[] args) {

        // Create a HashSet<String> of city names
        // HashSet does not allow duplicates and does not keep insertion order
        HashSet<String> cities = new HashSet<>();

        // Add 5 cities with add()
        cities.add("Chennai");
        cities.add("Thirunelvelli");
        cities.add("Tuticorin");
        cities.add("Bangalore");
        cities.add("Hyderabad");

        // Add one city twice and see what happens
        // add() returns false and the set stays the same size, since HashSet ignores duplicates
        cities.add("Chennai"); // This will NOT be added again

        // Print the full set
        System.out.println("Cities: " + cities);

        // Remove one city with remove()
        cities.remove("Tuticorin");

        // Check if a city exists with contains()
        boolean exists = cities.contains("Chennai");
        System.out.println("Is Chennai present? " + exists);

        // Loop through and print each city
        System.out.println("All cities:");
        for (String city : cities) {
            System.out.println(city);
        }

        // Print the size with size()
        System.out.println("Size of set: " + cities.size());
    }
}
//O/P
//        Cities: [Tuticorin, Chennai, Hyderabad, Thirunelvelli, Bangalore]
//        Is Chennai present? true
//        All cities:
//        Chennai
//                Hyderabad
//        Thirunelvelli
//                Bangalore
//        Size of set: 4