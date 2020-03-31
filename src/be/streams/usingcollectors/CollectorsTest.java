package be.streams.usingcollectors;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsTest {
    public static void main(String[] args) {

    Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
    String result = ohMy.collect(Collectors.joining(", "));
    System.out.println(result); // lions, tigers, bears

        Stream<String> ohMy2 = Stream.of("lions", "tigers", "bears");
        Double resultDouble = ohMy2.collect(Collectors.averagingInt(String::length));
        System.out.println(resultDouble); // 5.333333333333333


      //  Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        //  TreeSet<String> result = ohMy.filter(s -> s.startsWith("t")
      //          .collect(Collectors.toCollection(TreeSet::new));
        //          System.out.println(result); // [tigers]

        Stream<String> ohMy3 = Stream.of("lions", "tigers", "bears");
        Map<String, Integer> map = ohMy3.collect(
                Collectors.toMap(s -> s, String::length));
        System.out.println(map); // {lions=5, bears=5, tigers=6}


        //Stream<String> ohMy4 = Stream.of("lions", "tigers", "bears");
        //Map<Integer, String> map2 = ohMy4.collect(Collectors.toMap(String::length, k -> k)); // BAD
        Stream<String> ohMy5 = Stream.of("lions", "tigers", "bears");
        Map<Integer, String> map3 = ohMy5.collect(Collectors.toMap(
                String::length, k -> k, (s1, s2) -> s1 + "," + s2));
        System.out.println(map3); // {5=lions,bears, 6=tigers}
        System.out.println(map3.getClass()); // class. java.util.HashMap


        Stream<String> ohMy6 = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, String> map4 = ohMy6.collect(Collectors.toMap(
                String::length, k -> k, (s1, s2) -> s1 + "," + s2, TreeMap::new));
        System.out.println(map4); // // {5=lions,bears, 6=tigers}
        System.out.println(map4.getClass()); // class. java.util.TreeMap
    }
}

