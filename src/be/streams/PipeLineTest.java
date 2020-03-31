package be.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PipeLineTest {
    public static void main(String[] args){
        List<String> list = Arrays.asList("Toby", "Anna", "Leroy", "Alex");
        list.stream().filter(n -> n.length() == 4).sorted()
                .limit(2).forEach(System.out::println);

        list.stream().filter(n -> n.length() == 4) .sorted()
                .limit(2) .forEach(System.out::println);


       // Stream.generate(() -> "Elsa") .filter(n -> n.length() == 4) .sorted()
       //         .limit(2) .forEach(System.out::println);  //hangs

        Stream.generate(() -> "Elsa") .filter(n -> n.length() == 4) .limit(2)
                .sorted() .forEach(System.out::println);

        Stream.generate(() -> "Olaf Lazisson") .filter(n -> n.length() == 4) .limit(2)
                .sorted() .forEach(System.out::println);
    }
}
