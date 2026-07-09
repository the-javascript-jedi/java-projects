package shapes;

public class Main {
    public static void main(String[] args){
        // Even though circle/rectangle are declared with their concrete
        // types here, printArea() below is resolved at runtime based on
        // the actual object type (this is dynamic dispatch/polymorphism).
        Circle circle=new Circle(5);
        circle.printArea();

        Rectangle rectangle=new Rectangle(5,3);
        rectangle.printArea();
    }
}
