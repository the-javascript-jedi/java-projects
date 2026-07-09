package animals;

// Base class for all animals. Holds the state and behavior every animal
// shares (name, age, eating, sleeping). Dog/Cat extend this to add their
// own specific behavior (bark/meow) without duplicating this code.
public class Animal {
// private fields = encapsulation: subclasses and outside code can't touch
// these directly, they must go through the getters below.
private String name;
private int age;

// Constructor: runs when "new Animal(...)" (or a subclass's super(...)) is called.
public Animal(String name, int age){
    this.name=name;
    this.age=age;
}

public String getName(){
    return this.name;
}

    public int getAge(){
        return this.age;
    }

    // Shared behavior — inherited as-is by Dog and Cat, no need to redefine it there.
    public void eat(){
        System.out.println(getName() +" is eating");
    }

    public void sleep(){
        System.out.println(getName() +" is sleeping");
    }
}