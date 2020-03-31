package be.operator;

import java.util.function.UnaryOperator;

public class UnaryOperatorTest {
    public static void main(String [] args){
        UnaryOperator<String> u1 = String::toUpperCase;
        UnaryOperator<String> u2 = x -> x.toUpperCase();
        System.out.println(u1.apply("chirp"));
        System.out.println(u2.apply("chirp"));
    }
}
