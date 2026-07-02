/*
 * Problem: First Unique Character
 * Given a string, return the index of the first character that does not repeat.
 * Return -1 if no unique character exists.
 *
 * Input:  "leetcode"
 * Output: 0  → 'l' appears only once, first at index 0
 *
 * Example 2:
 * Input:  "loveleetcode"
 * Output: 2  → 'v' appears only once, first at index 2
 *
 * Example 3:
 * Input:  "aabb"
 * Output: -1  → every character repeats, no unique character
 *
 * Approach: Two passes — first count each character's frequency using a HashMap,
 * then find the first character with count 1.
 * Time complexity: O(n)
 */
package array_basics;

import java.util.HashMap;

public class FindFirstUniqueChar {

    public static int firstNonRepeatingChar(String str) {

        // This map will store: character -> how many times it appears
        // Example: for "aab" it will end up as {a=2, b=1}
        HashMap<Character, Integer> frequency = new HashMap<>();

        // ---- PASS 1: Count how many times each character appears ----
        // str.toCharArray() breaks the string into individual chars: 'a','a','b'...
        // We loop over each one and update its count in the map.
        for (char ch : str.toCharArray()) {

            if (frequency.containsKey(ch)) {
                // We've seen this character before → increase its count by 1
                frequency.put(ch, frequency.get(ch) + 1);
            } else {
                // First time seeing this character → start its count at 1
                frequency.put(ch, 1);
            }
        }
        // short form - getOrDefault is just a HashMap method that saves you a manual null-check. Its signature:
        // Count the frequency of each character
        // for (char ch : str.toCharArray()) {
        //   frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        //}

        // At this point, "frequency" knows the count of every character.
        // Example for "aab": {a=2, b=1}

        // ---- PASS 2: Walk through the string AGAIN, in original order ----
        // We need this second pass because a HashMap has no guaranteed order,
        // so we can't rely on it to tell us which character came FIRST in the string.
        // The string itself (str.charAt(i)) still remembers the original order.
        for (int i = 0; i < str.length(); i++) {

            // Look up how many times the character at position i appears
            char currentChar = str.charAt(i);
            int count = frequency.get(currentChar);

            // If it appears exactly once, this is our answer — return its index immediately
            if (count == 1) {
                return i;
            }
        }

        // If we finish the loop without finding any character with count == 1,
        // it means every character repeats → return -1
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingChar("leetcode"));      // 0
        System.out.println(firstNonRepeatingChar("loveleetcode"));  // 2
        System.out.println(firstNonRepeatingChar("aabb"));          // -1
    }
}