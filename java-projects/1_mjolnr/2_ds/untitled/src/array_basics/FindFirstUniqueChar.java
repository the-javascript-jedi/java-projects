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
        HashMap<Character, Integer> frequency = new HashMap<>();

        // Count the frequency of each character
        for (char ch : str.toCharArray()) {
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        // Find the first non-repeating character
        for (int i = 0; i < str.length(); i++) {
            if (frequency.get(str.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingChar("leetcode"));      // 0
        System.out.println(firstNonRepeatingChar("loveleetcode"));  // 2
        System.out.println(firstNonRepeatingChar("aabb"));          // -1
    }
}