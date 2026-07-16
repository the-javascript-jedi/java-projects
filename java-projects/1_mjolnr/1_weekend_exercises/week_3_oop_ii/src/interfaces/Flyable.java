package interfaces;

// An interface is a pure contract: no fields, no method bodies (just signatures).
// Any class that "implements Flyable" is promising it will provide its own fly().
public interface Flyable {
    void fly();
}
