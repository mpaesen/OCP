package be.supplier;

import java.util.function.Supplier;

public class StringBuilderSupplier {

    public static void main(String[] args) {

        Supplier<StringBuilder> s1 = StringBuilder::new;
        Supplier<StringBuilder> s2 = () -> new StringBuilder();


        System.out.println(s1.get());
        System.out.println(s2.get());


    }
}
