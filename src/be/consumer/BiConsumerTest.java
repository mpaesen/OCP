package be.consumer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerTest {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        BiConsumer<String, Integer> b1 = map::put;
        BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);
        b1.accept("chicken", 7);
        b2.accept("chick", 1);
        System.out.println(map);


        Map<String, String> map2 = new HashMap<>();
        BiConsumer<String, String> b11 = map2::put;
        BiConsumer<String, String> b12 = (k, v) -> map2.put(k, v);
        b11.accept("chicken", "Cluck");
        b12.accept("chick", "Tweep");
        System.out.println(map2);
    }
}
