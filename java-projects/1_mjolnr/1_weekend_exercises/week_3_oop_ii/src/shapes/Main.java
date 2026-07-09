package shapes;

public class Main {
    public static void main(String[] args){
        // Even though circle/rectangle are declared with their concrete
        // types here, printArea() below is resolved at runtime based on
        // the actual object type (this is dynamic dispatch/polymorphism).
        Circle circle=new Circle(5);
        circle.printArea(); // prints: Circle Area:78.53981633974483

        Rectangle rectangle=new Rectangle(5,3);
        rectangle.printArea(); // prints: Rectangle Area: 15.00
    }
}
