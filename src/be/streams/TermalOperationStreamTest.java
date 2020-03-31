package be.streams;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TermalOperationStreamTest {

    public  static void main(String[] args) {


    Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
    //System.out.println(s.count()); // 3

    s =Stream.of("monkey","ape","bonobo");
    Optional<String> min = s.min((s1, s2) -> {
        return s1.length() - s2.length();
    });
        min.ifPresent(System.out::println); // ape


    Optional<?> minEmpty = Stream.empty().min((s1, s2) -> 0);
        System.out.println(minEmpty.isPresent()); // false

    s =Stream.of("monkey","gorilla","bonobo");
    Stream<String> infinite = Stream.generate(() -> "chimp");
        s.findAny().

    ifPresent(System.out::println); // monkey
        infinite.findAny().

    ifPresent(System.out::println); // chimp

        List<String> list =Arrays.asList("monkey","2","chimp");
    infinite =Stream.generate(()->"chimp");
    Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
        System.out.println(list.stream().

    anyMatch(pred)); // true
        System.out.println(list.stream().

    allMatch(pred)); // false
        System.out.println(list.stream().

    noneMatch(pred)); // false
        System.out.println(infinite.anyMatch(pred)); // true

    s =Stream.of("Monkey","Gorilla","Bonobo");
        s.forEach(System.out::print); // MonkeyGorillaBonobo
        System.out.println();

    Stream<String> stream = Stream.of("w", "o", "l", "f");
    String word = stream.reduce("", (ss, c) -> ss + c); //concatenate
        System.out.println(word); // wolf

    Stream<Integer> multstream = Stream.of(3, 5, 6);
        System.out.println(multstream.reduce(1,(a,b)->a*b));


    BinaryOperator<Integer> op = (a, b) -> a * b;
    Stream<Integer> empty = Stream.empty();
    Stream<Integer> oneElement = Stream.of(3);
    Stream<Integer> threeElements = Stream.of(3, 5, 6);
        empty.reduce(op).

    ifPresent(System.out::print); // no output

        oneElement.reduce(op).

    ifPresent(System.out::print); // 3
        System.out.println();
        threeElements.reduce(op).

    ifPresent(System.out::print); // 90

        System.out.println();
    BinaryOperator<Integer> opp = (a, b) -> a * b;
    Stream<Integer> intstream = Stream.of(3, 5, 6);
        System.out.println(intstream.reduce(1,opp,opp)); // 90


    stream =Stream.of("w","o","l","f");
    StringBuilder word2 = stream.collect(StringBuilder::new,
            StringBuilder::append, StringBuilder::append);

    stream =Stream.of("w","o","l","f");
    TreeSet<String> set = stream.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        System.out.println(set); // [f, l, o, w]

    stream =Stream.of("w","o","l","f");
    TreeSet<String> set1 = stream.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set1); // [f, l, o, w]

    stream =Stream.of("w","o","l","f");
    Set<String> set2 = stream.collect(Collectors.toSet());
        System.out.println(set2); // [f, w, l, o]
}
}
