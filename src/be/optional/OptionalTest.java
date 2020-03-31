package be.optional;

import java.util.Optional;

public class OptionalTest {
    public static Optional<Double> average(int... scores) {
        if (scores.length == 0)
            return Optional.empty();

        int sum = 0;
        for (int score : scores)
            sum += score;
        return Optional.of((double) sum / scores.length);

    }

    public static void main(String[] args){
        System.out.println(average());
        System.out.println(average(10));
        System.out.println(average(10,20));
        System.out.println(average(10, 20, 30));

        Optional<Double> opt = average(90,100);
        if (opt.isPresent())
                System.out.println(opt.get());

        opt = average();
        //System.out.println(opt.get());  //not present!!!


        Optional o = (opt== null) ? Optional.empty(): Optional.of(opt);
        o = Optional.ofNullable(opt);


       opt = average(90, 100);
       opt.ifPresent(System.out::println);

        opt = average();
        System.out.println(opt.orElse(Double.NaN));
        System.out.println(opt.orElseGet(() -> Math.random()));
        //System.out.println(opt.orElseThrow(() -> new IllegalStateException()));


        opt = average(90, 100);
        System.out.println(opt.orElse(Double.NaN));
        System.out.println(opt.orElseGet(() -> Math.random()));
        System.out.println(opt.orElseThrow(() -> new IllegalStateException()));

    }
}
