/*
 * Problem: Rectangle — Encapsulation Practice
 * Create a class representing a rectangle that calculates its own
 * area and perimeter, with private fields accessed only through getters.
 *
 * Fields: width (double), height (double)
 *
 * Input:  Rectangle rect = new Rectangle(200, 100);
 *         rect.printDetails();
 * Output: Width: 200.0| Height:100.0|Area:20000.0|Perimeter600.0
 *
 * Approach: Store width and height as private fields so they can't be
 * changed directly from outside the class. Expose read-only access via
 * getWidth()/getHeight(). Compute area and perimeter on demand rather
 * than storing them, so they're always accurate even if fields change.
 * Time complexity: O(1) for all operations
 */
package rectangle;

public class Rectangle {

    // Private fields — encapsulated, can't be accessed directly from outside this class
    private double width;
    private double height;

    // Constructor — sets both fields when a Rectangle object is created
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Getter — controlled read access to width
    public double getWidth() {
        return width;
    }

    // Getter — controlled read access to height
    public double getHeight() {
        return height;
    }

    // Calculated on the fly rather than stored — always reflects current width/height
    public double getArea() {
        return width * height;
    }

    // Perimeter formula: 2 * (width + height)
    public double getPerimeter() {
        return 2 * (width + height);
    }

    // Prints all details using the getters (not the raw fields) — good practice,
    // since it means this method would still work even if fields were renamed internally
    public void printDetails() {
        System.out.println("Width: " + getWidth() + "|" + " Height:" + getHeight() + "|" + "Area:" + getArea() + "|" + "Perimeter" + getPerimeter());
    }

    // Entry point — creates a Rectangle and prints its details
    public static void main(String args[]) {
        Rectangle rect = new Rectangle(200, 100);
        rect.printDetails();
    }
}