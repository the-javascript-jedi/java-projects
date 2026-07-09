package interfaces;

// Eagle only implements Flyable (no swimming) - each class picks only the
// interfaces that describe behavior it actually has.
public class Eagle implements Flyable{
    private String name;
    public Eagle(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    // Fulfills the Flyable contract - Eagle's own version of fly().
    @Override
    public void fly(){
        System.out.println(getName()+" is flying high");
    }
}
