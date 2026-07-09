package abstractanimals;

// Dog is another concrete subclass - same idea as Cat, different makeSound() implementation.
public class Dog extends Animal{
    public Dog(String name){
        super(name);
    }
    @Override
    public void makeSound(){
        System.out.println(getName()+" says woof");
    }
}
