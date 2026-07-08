/*
 * Problem: Car — Static Fields & Methods Practice
 * Create a class representing a car, using a static field to track
 * how many Car objects have been created across the whole program.
 *
 * Fields: brand (String, instance), speed (int, instance), totalCars (int, static)
 *
 * Input:  Car carObj1 = new Car("Toyota");
 *         carObj1.accelerate(60);
 *         carObj1.printDetails();
 *         Car carObj2 = new Car("Scorpio");
 *         carObj2.accelerate(95);
 *         carObj2.printDetails();
 *         System.out.println(Car.getTotalCars());
 * Output: Brand: Toyota| Speed: 60
 *         Brand: Scorpio| Speed: 95
 *         2
 *
 * Approach: speed is an instance field, so each Car object keeps its own
 * separate value. totalCars is static, so there's only ONE copy shared
 * across every Car object ever created — it's incremented once per
 * constructor call. brake() uses a guard clause to clamp speed at 0
 * instead of letting it go negative.
 * Time complexity: O(1) for all operations
 */
package car;

public class Car {

    // Instance fields — each Car object gets its own separate copy
    private String brand;
    private int speed;

    // Static field — shared across ALL Car objects, only one copy exists in memory
    private static int totalCars;

    // Constructor — speed always starts at 0 regardless of input,
    // totalCars is incremented every time a new Car is created
    public Car(String brand){
        this.brand=brand;
        this.speed=0;
        totalCars++;   // no "this." — totalCars belongs to the class, not this object
    }

    // Adds the given amount to this car's speed
    public void accelerate(int amount){
        this.speed=this.speed+amount;
    }

    // Subtracts the given amount from speed, but never lets it go below 0
    public void brake(int amount){
        this.speed=this.speed-amount;
        if(this.speed<0){
            this.speed=0;   // guard clause — clamp instead of allowing negative speed
        }
    }

    // Getter — controlled read access to brand
    public String getBrand(){
        return this.brand;
    }

    // Getter — controlled read access to speed
    public int getSpeed(){
        return this.speed;
    }

    // Prints this car's brand and current speed
    public void printDetails(){
        System.out.println("Brand: "+ getBrand() +"| Speed: "+getSpeed());
    }

    // Static method — belongs to the class itself, not any one Car object.
    // Called as Car.getTotalCars(), not carObj.getTotalCars()
    public static int getTotalCars(){
        return totalCars;
    }

    // Entry point — creates two Car objects, exercises their behavior,
    // and prints the shared totalCars count
    public static void main(String args[]){
        Car carObj1=new Car("Toyota");
        carObj1.accelerate(60);
        carObj1.printDetails();

        Car carObj2=new Car("Scorpio");
        carObj2.accelerate(95);
        carObj2.printDetails();

        System.out.println(Car.getTotalCars());
    }
}
