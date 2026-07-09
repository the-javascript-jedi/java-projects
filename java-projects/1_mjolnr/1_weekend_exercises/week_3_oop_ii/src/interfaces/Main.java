package interfaces;

public class Main {
    public static void main (String args[]){
        // Eagle only has fly() available - it never implemented Swimmable.
        Eagle eagle=new Eagle("Obama Eagle");
        eagle.fly(); // prints: Obama Eagle is flying

        // Duck has both fly() and swim() since it implements both interfaces.
        Duck duck=new Duck("Donald Duck");
        duck.fly();  // prints: Donald Duck is flying
        duck.swim(); // prints: Donald Duck is swimming
    }
}

