package abstractanimals;

public class Main {

    public static void main(String args[]){
        // makeSound() runs each subclass's own override; sleep() runs the shared Animal version.
        Dog dog=new Dog("tommy");
        dog.makeSound();   // prints: tommy says woof
        dog.sleep();       // prints: tommy is sleeping

        Cat cat=new Cat("whiskers");
        cat.makeSound();   // prints: whiskers says : MEow!
        cat.sleep();       // prints: whiskers is sleeping

        //'Animal' is abstract; cannot be instantiated
        //below code will cause error
        // Animal animal=new Animal("test");
    }
}
