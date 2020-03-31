package be.supplier;

import java.util.ArrayList;
import java.util.function.Supplier;

public class ArrayListSupplier {
    public static void main(String[] args) {
        Supplier<ArrayList<String>> s1 = ArrayList<String>::new;
        ArrayList<String> a1 = s1.get();

        System.out.println(a1);
        System.out.println(s1);
    }
}
