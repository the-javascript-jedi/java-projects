package shapes;

// Circle is-a Shape, so it inherits from Shape and overrides
// getArea()/printArea() with circle-specific logic.
public class Circle extends Shape{
    private double radius;

    // Constructor: set the radius when a Circle is created.
    public Circle(double radius){
        this.radius=radius;
    }

    // @Override tells the compiler this must match a method in Shape;
    // it replaces the parent's version when called on a Circle.
    @Override
    public double getArea(){
        return Math.PI * radius*radius;
    }

    @Override
    public void printArea(){
        System.out.println("Circle Area:"+getArea());
    }
}


