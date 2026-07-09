package abstractanimals;

// 'abstract' means this class can't be instantiated directly (no "new Animal()").
// It only exists to be extended by concrete subclasses like Cat and Dog.
public abstract class Animal {

    private String name;

    // Constructor - subclasses call this via super(name) to set the shared field.
    public Animal(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    // Concrete (non-abstract) method: shared behavior every subclass inherits as-is.
    public void sleep(){
        System.out.println(getName()+" is sleeping");
    }

    // Abstract method: no body here - each subclass MUST provide its own implementation.
    // This is what forces Cat and Dog to each define their own makeSound().
    public abstract void makeSound();
}

