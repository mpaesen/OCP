package be.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperationStreamTest {
    public static void main(String[] args){
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        s.filter(x -> x.startsWith("m")).forEach(System.out::print); // monkey

        System.out.println();
        s = Stream.of("duck", "duck", "duck", "goose");
        s.distinct().forEach(System.out::print); // duckgoose

        System.out.println();
        Stream<Integer> si = Stream.iterate(1, n -> n + 1);
        si.skip(5).limit(2).forEach(System.out::print); // 67

        System.out.println();
        s = Stream.of("monkey", "gorilla", "bonobo");
        s.map(String::length).forEach(System.out::print); // 676

        System.out.println();
        List<String> zero = Arrays.asList();
        List<String> one = Arrays.asList("Bonobo");
        List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
        Stream<List<String>> animals = Stream.of(zero, one, two);
        animals.flatMap(l -> l.stream()).forEach(System.out::println);

        System.out.println();
        s = Stream.of("brown-", "bear-");
        s.sorted().forEach(System.out::print); // bear-brown-

        System.out.println();
        s = Stream.of("brown bear-", "grizzly-");
        s.sorted(Comparator.reverseOrder())
                .forEach(System.out::print); // grizzly-brown bear-

        System.out.println();
        Stream<String>stream = Stream.of("black bear", "brown bear", "grizzly");
        long count = stream.filter(ss -> ss.startsWith("g"))
                .peek(System.out::println).count(); // grizzly
        System.out.println(count); // 1

    }
}
