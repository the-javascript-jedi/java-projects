package interfaces;

// Separate interface for swimming behavior, kept independent from Flyable.
// This lets classes mix and match: implement just one, or both (see Duck vs Eagle).
public interface Swimmable {
    void swim();
}
