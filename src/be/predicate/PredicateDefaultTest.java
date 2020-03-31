package be.predicate;

import java.util.function.Predicate;

public class PredicateDefaultTest {
    public static void main(String [] args){
        Predicate<String> egg = s -> s.contains("egg");
        Predicate<String> brown = s -> s.contains("brown");

        Predicate<String> brownEggs = egg.and(brown);
        Predicate<String> otherEggs = egg.and(brown.negate());

        String s = new String("a bird produces eggs");
        String str = new String("some birds produce brown eggs");

        System.out.println(egg.test(s));
        System.out.println(brown.test(s));
        System.out.println(brownEggs.test(str));
        System.out.println(otherEggs.test(str));
    }
}
