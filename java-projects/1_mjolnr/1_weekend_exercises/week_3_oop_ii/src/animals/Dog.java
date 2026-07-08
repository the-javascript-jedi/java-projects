package animals;

// Dog IS-AN Animal: inherits name/age/eat()/sleep() for free, only needs
// to add what's unique to dogs (bark()).
public class Dog extends Animal {
    public Dog(String name, int age){
        // super(...) calls Animal's constructor to set up name/age,
        // since those fields are private to Animal and Dog can't set them directly.
        super(name,age);
    }

    public void bark(){
        System.out.println(getName()+" is barking");
    }

}
