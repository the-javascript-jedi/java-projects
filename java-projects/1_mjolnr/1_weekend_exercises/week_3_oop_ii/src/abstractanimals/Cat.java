package abstractanimals;

// Cat is a concrete subclass - it "fills in" the abstract makeSound() method from Animal.
public class Cat extends Animal {
    public Cat(String name){
        // Passes the name up to Animal's constructor to be stored there.
        super(name);
    }

    // @Override confirms this is overriding Animal's abstract method (compiler checks the signature matches).
    @Override
    public void makeSound(){
        System.out.println(getName()+" says : MEow!");
    }
}
