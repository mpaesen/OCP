package be.streams.primitives;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveTest {
    public static void main(String[]args){
        Stream<Integer> stream = Stream.of(1, 2, 3);
        System.out.println(stream.reduce(0, (s, n) -> s + n));

        stream = Stream.of(1, 2, 3);
        System.out.println(stream.mapToInt(x -> x).sum());

        IntStream intStream = IntStream.of(1, 2, 3);
        OptionalDouble avg = intStream.average();
        System.out.println(avg.getAsDouble());

        DoubleStream oneValue = DoubleStream.of(3.14);
        DoubleStream varargs = DoubleStream.of(1.0, 1.1, 1.2);
        oneValue.forEach(System.out::println);
        System.out.println();
        varargs.forEach(System.out::println);

        System.out.println();
        DoubleStream random = DoubleStream.generate(Math::random);
        DoubleStream fractions = DoubleStream.iterate(.5, d -> d / 2);
        random.limit(3)
                .forEach(System.out::println);
        System.out.println();
        fractions.limit(3)
                .forEach(System.out::println);

        System.out.println();
        IntStream count = IntStream.iterate(1, n -> n+1)
                .limit(5);
        count.forEach(System.out::println);

        System.out.println();
        IntStream range = IntStream.range(1, 6);
        range.forEach(System.out::println);

        System.out.println();
        IntStream rangeClosed = IntStream.rangeClosed(1, 5);
        rangeClosed.forEach(System.out::println);

        System.out.println();
        Stream<String> objStream = Stream.of("penguin", "fish");
        intStream = objStream.mapToInt(s -> s.length());
        intStream.forEach(System.out::println);

        System.out.println();
        Integer [] arrayInt = {1,2,3,4,5,6};
        List<Integer> list = Arrays.asList(arrayInt);
        IntStream ints = list.stream()
                .flatMapToInt(x -> IntStream.of(x));
        ints.forEach(System.out::println);

    }
}
