package be.streams;

import java.util.stream.Stream;

public class PeekBehindTheScenes {
    public static void main(String[] args){
        Stream<Integer> infinite = Stream.iterate(1, x -> x + 1);
        infinite.limit(5)
                .filter(x -> x % 2 == 1)
                .forEach(System.out::print); // 135

        System.out.println();
        infinite = Stream.iterate(1, x -> x + 1);
        infinite.limit(5)
                //.peek(System.out::print)
                .filter(x -> x % 2 == 1)
                .forEach(System.out::print);

        System.out.println();
        infinite = Stream.iterate(1, x -> x + 1);
        infinite.filter(x -> x % 2 == 1)
                .limit(5)
                .forEach(System.out::print); // 13579

        System.out.println();
        infinite = Stream.iterate(1, x -> x + 1);
        infinite.filter(x -> x % 2 == 1)
                //.peek(System.out::print)
                .limit(5)
                .forEach(System.out::print);
    }

}
