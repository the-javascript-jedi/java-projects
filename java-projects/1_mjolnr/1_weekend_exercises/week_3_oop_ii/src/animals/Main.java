package animals;

public class Main {
    public static void main(String[] args){
        Dog dog=new Dog("tommy",2);
        dog.eat();   // inherited from Animal   -> prints: tommy is eating
        dog.bark();  // defined on Dog          -> prints: tommy is barking
        dog.sleep(); // inherited from Animal   -> prints: tommy is sleeping

        Cat cat=new Cat("whiskers",3);
        cat.eat();   // inherited from Animal   -> prints: whiskers is eating
        cat.meow();  // defined on Cat          -> prints: whiskers is meowing
        cat.sleep(); // inherited from Animal   -> prints: whiskers is sleeping
    }
}
