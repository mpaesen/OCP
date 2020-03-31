package be.streams.usingcollectors;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

public class GroupingTest {
    public static void main(String[] args) {
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> map = ohMy.collect(
                Collectors.groupingBy(String::length));
        System.out.println(map); // {5=[lions, bears], 6=[tigers]}
    }

}
