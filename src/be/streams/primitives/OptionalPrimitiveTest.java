package be.streams.primitives;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class OptionalPrimitiveTest {
    public static void main(String[]args){
        IntStream stream = IntStream.rangeClosed(1,10);
        OptionalDouble optional = stream.average();
        optional.ifPresent(System.out::println);
        System.out.println(optional.getAsDouble());
        System.out.println(optional.orElseGet(() -> Double.NaN));



        System.out.println();
        LongStream longs = LongStream.of(5, 10);
        long sum = longs.sum();

        System.out.println(sum); // 15

        DoubleStream doubles = DoubleStream.generate(() -> Math.PI);
       // OptionalDouble min = doubles.min(); // runs infinitely

        stream = IntStream.rangeClosed(1,10);
        //System.out.println(max(stream));
        System.out.println(range(stream));



    }

    private static int max(IntStream ints) {
        OptionalInt optional = ints.max();
        return optional.orElseThrow(RuntimeException::new);
    }

    private static int range(IntStream ints) {
        IntSummaryStatistics stats = ints.summaryStatistics();
        if (stats.getCount() == 0) throw new RuntimeException();
        return stats.getMax()-stats.getMin();
    }
}
