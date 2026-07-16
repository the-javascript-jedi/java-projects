package collections;

import java.util.HashMap;

public class WordFrequencyCounter {
    public void frequencyCounter(String sentence){
        // two maps just to compare two ways of building the same count table
        HashMap<String,Integer> frequencyOne=new HashMap<>();
        HashMap<String,Integer> frequencyTwo=new HashMap<>();

        // split on single spaces -> array of individual words
        // (won't handle punctuation, double spaces, or mixed case correctly)
        String[] words=sentence.split(" ");

        // --- approach 1: getOrDefault "shortcut" ---
        // getOrDefault(word, 0) returns the current count, or 0 if the word
        // hasn't been seen yet, then we +1 and store it back in one line.
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]); // debug: prints each word as it's processed
            String word=words[i];
            frequencyOne.put(word,frequencyOne.getOrDefault(word,0)+1);
        }
        System.out.println("frequencyOne"+frequencyOne);

        // --- approach 2: manual containsKey check (same result, more verbose) ---
        // explicitly checks if the word is already a key before deciding
        // whether to increment the existing count or insert it for the first time
        for (int i = 0; i < words.length; i++) {
            int count;
            String word=words[i];
            if(frequencyTwo.containsKey(word)){
                count = frequencyTwo.get(word);
                frequencyTwo.put(word, count + 1);
            }else {
                frequencyTwo.put(word, 1);
            }
        }
        System.out.println("frequencyTwo"+frequencyTwo);

    }

    public static void main(String[] args){
        String sentence = "java is fun and java is powerful";
        WordFrequencyCounter wfc=new WordFrequencyCounter();
        wfc.frequencyCounter(sentence);
    }
}

/*
O/P
java
 is
 fun
 and
 java
 is
 powerful
 frequencyOne{java=2, powerful=1, and=1, is=2, fun=1}
 frequencyTwo{java=2, powerful=1, and=1, is=2, fun=1}
 */


