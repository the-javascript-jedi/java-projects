package shapes;

// Rectangle is-a Shape, same pattern as Circle: extend Shape and
// override the area methods with rectangle-specific logic.
public class Rectangle extends Shape {
    private double height;
    private double width;

    // Note: parameters are (height, width) here, but Main calls
    // new Rectangle(5, 3) intending (width, height) - order is currently swapped.
    Rectangle(double height,double width){
        this.width=width;
        this.height=height;
    }

    // Overrides Shape.getArea(). Replaces the parent's "return 0.0" with
    // the actual rectangle formula; called automatically instead of
    // Shape's version whenever this is invoked on a Rectangle object.
    @Override
    public double getArea(){
        return width*height;
    }

    // Overrides Shape.printArea() the same way, so calling printArea()
    // on a Rectangle prints its own message instead of Shape's "Area: 0.0".
    @Override
    public void printArea(){
        // %.2f restricts the printed double to 2 decimal places.
        System.out.println("Rectangle Area: "+String.format("%.2f", getArea()));
    }
}
