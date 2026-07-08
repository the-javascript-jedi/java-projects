package animals;

// Same pattern as Dog: inherits from Animal, adds its own meow() behavior.
public class Cat extends Animal {

    public Cat(String name, int age){
        super(name,age);
    }

    public void meow(){
        System.out.println(getName()+" is meowing");
    }
}
