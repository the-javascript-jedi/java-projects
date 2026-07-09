package shapes;

// Base class for all shapes. Subclasses override these methods to
// provide their own area calculation (this is polymorphism).
public class Shape {
    // Default implementation returns 0.0 since a generic "Shape" has no defined area.
    public double getArea(){
        return 0.0;
    }

    public void printArea(){
        System.out.println("Area: 0.0");
    }
}
