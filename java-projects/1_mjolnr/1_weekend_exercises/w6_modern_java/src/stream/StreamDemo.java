package stream;

import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args){
        // List.of() creates an immutable list - can't add/remove/set elements on it
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 1. Filter even numbers
        // stream() turns the list into a Stream so we can chain operations on it.
        // filter() keeps only elements where the lambda returns true (n % 2 == 0 -> even).
        // forEach() is a "terminal" operation - it runs the stream and prints each surviving element.
        // Nothing above happens until forEach() is called; streams are lazy.
        numbers.stream().filter((n)->n%2==0).forEach(n->System.out.println("filter even numbers"+n));

        // 2. Map each number to its square
        // map() transforms each element (here: n -> n*n) and produces a new stream of the results.
        // It's a 1-to-1 transformation, unlike filter() which just selects a subset.
        numbers.stream().map(n->n*n).forEach(n->System.out.println("numbers square"+n));

        // 3. Filter > 5, square them, collect to list
        // Operations can be chained: first filter down to n > 5, then square what's left.
        // collect(Collectors.toList()) is a terminal operation that gathers the stream
        // results back into a concrete List (streams themselves can't be reused/iterated directly).
        List<Integer> squaredNumbers =  numbers.stream().filter(n->n>5).map(n->n*n).collect(Collectors.toList());
        System.out.println("squaredNumbers"+squaredNumbers);

        // 4. Sum all numbers using reduce()
        // reduce(identity, accumulator) combines all elements into a single value.
        // 0 is the starting value (identity/seed). The lambda (total, number) -> total + number
        // is applied repeatedly: total starts at 0, then becomes 0+1, 1+2, 3+3, ... until one value remains.
        int sum=numbers.stream().reduce(0,(total,number)->total+number);
        System.out.println("sum "+sum);

        // 5. Count numbers greater than 5
        // count() returns a long by design:
        // filter() narrows the stream to elements > 5, then count() (a terminal operation)
        // returns how many elements are left, as a long (streams can theoretically hold more than Integer.MAX_VALUE elements).
        long count=numbers.stream().filter(v->v>5).count();
        System.out.println("count "+count);

    }
}

