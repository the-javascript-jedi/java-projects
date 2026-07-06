package exercises;

public class CountVowels {

    // counts how many vowels (a, e, i, o, u) are in the string
    public static int countVowels(String s) {
        int count = 0;                                    // running tally
        for (int i = 0; i < s.length(); i++) {
            // lowercase each char first, so 'A' and 'a' both count
            char ch = Character.toLowerCase(s.charAt(i));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;                                  // found a vowel
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countVowels("Mario"));         // 3  (a, i, o)
        System.out.println(countVowels("hello"));         // 2  (e, o)
        System.out.println(countVowels("xyz"));           // 0
        System.out.println(countVowels("AEIOU"));         // 5  (caught thanks to toLowerCase)
        System.out.println(countVowels(""));              // 0  (empty string)
    }
}