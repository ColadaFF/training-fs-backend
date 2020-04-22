package co.edu.ff.orders;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FlatMap {
    public static Optional<Integer> transformInteger(Integer a) {
        return Optional.of(a)
                .map(integer -> integer * 2);
    }
    // 0
    // 1 -> [0, 2]
    // 2 -> [0, 2, 4]
    // 3 -> [0, 2, 4, 6]
    public static Stream<Integer> createStream(Integer limit){
        return IntStream.range(0, limit)
                .mapToObj(i -> i * 2);
    }



    public static void main(String[] args) {
        // map A -> B
        // filter A -/ A
        // flatMap

        // [[Integer]]
        // [Integer]
        Optional<Integer> op1 =  Optional.of(3)
                .flatMap(integer -> transformInteger(integer));


        Stream<Integer> streams =  IntStream.range(0, 10) // intStream
            .mapToObj(i -> createStream(i)) // Stream[Stream[Int]]
                .flatMap(stream -> stream); // Stream[Int]

        // [[0], [0, 2], [0, 2, 4]]
        // [0, 0, 2, 0, 2, 4]
        streams.forEach(integer -> {
            System.out.println(integer);
        });
    }
}
