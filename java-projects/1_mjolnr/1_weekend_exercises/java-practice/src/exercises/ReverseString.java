package exercises;

public class ReverseString {

    // builds a reversed copy by walking the original string backwards
    public static String reverseString(String str) {
        String reversed = "";                          // start with an empty result
        // start at the LAST index (length-1), walk down to 0
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed = reversed + str.charAt(i);       // append each char to the result
        }
        return reversed;
    }

    public static void main(String[] args) {
        System.out.println(reverseString("rest"));     // tser
        System.out.println(reverseString("Mario"));    // oiraM
        System.out.println(reverseString("a"));        // a   (single char)
        System.out.println(reverseString(""));         // (empty stays empty)
        System.out.println(reverseString("racecar"));  // racecar (palindrome - same!)
    }
}