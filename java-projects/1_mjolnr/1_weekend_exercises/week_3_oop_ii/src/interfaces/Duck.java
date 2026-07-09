package interfaces;

// Duck implements BOTH interfaces - unlike class inheritance (single parent only),
// a class can implement as many interfaces as it wants, since interfaces have no state/behavior of their own to conflict.
public class Duck implements Flyable,Swimmable{
    private String name;
    public Duck(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    // Fulfills the Flyable contract.
    @Override
    public void fly(){
        System.out.println(getName()+" is flying");
    }

    // Fulfills the Swimmable contract.
    @Override
    public void swim(){
        System.out.println(getName()+" is swimming");
    }
}
