package animals;

public class Main {
    public static void main(String[] args){
        Dog dog=new Dog("tommy",2);
        dog.eat();   // inherited from Animal
        dog.bark();  // defined on Dog
        dog.sleep(); // inherited from Animal

        Cat cat=new Cat("whiskers",3);
        cat.eat();   // inherited from Animal
        cat.meow();  // defined on Cat
        cat.sleep(); // inherited from Animal
    }
}
