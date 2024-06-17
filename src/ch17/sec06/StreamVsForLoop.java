package ch17.sec06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.PrimitiveIterator.OfInt;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamVsForLoop {

    public static void main(String[] args) {
        int length = 10_000_000;
        int[] irr = new int[length];
        for (int i = 0; i < length; i++) {
            irr[i] = (int) (Math.random() * 100) + 1;
        }

        System.out.println("=== Primitive Type Test Start (Max) ===");

        int max1 = Integer.MIN_VALUE;
        long startTime1 = System.nanoTime();
        for (int i = 0; i < length; i++) {
            max1 = irr[i] > max1 ? irr[i] : max1;
//            max1 = Math.max(max1, irr[i]);
        }
        long endTime1 = System.nanoTime();
        long elapsedTime1 = endTime1 - startTime1;
        System.out.println("For문 결과: " + max1);
        System.out.println("For문 시간: " + elapsedTime1);

        int max2 = Integer.MIN_VALUE;
        long startTime2 = System.nanoTime();
        max2 = Arrays.stream(irr).reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
//        max2 = Arrays.stream(irr).reduce(Integer.MIN_VALUE, Math::max);
        long endTime2 = System.nanoTime();
        long elapsedTime2 = endTime2 - startTime2;
        System.out.println("Stream 결과: " + max2);
        System.out.println("Stream 시간: " + elapsedTime2);

        System.out.println("=== Primitive Type Test End (Max) ===");
        System.out.println();

        System.out.println("=== Wrapper Type Test Start (Max) ===");
        Integer[] irrWrapper = Arrays.stream(irr).boxed().toArray(Integer[]::new);

        Integer max3 = Integer.MIN_VALUE;
        long startTime3 = System.nanoTime();
        for (int i = 0; i < length; i++) {
            max3 = irrWrapper[i] > max3 ? irrWrapper[i] : max3;
//            max3 = Math.max(max3, irrWrapper[i]);
        }
        long endTime3 = System.nanoTime();
        long elapsedTime3 = endTime3 - startTime3;
        System.out.println("For문 결과: " + max3);
        System.out.println("For문 시간: " + elapsedTime3);

        Integer max4 = Integer.MIN_VALUE;
        long startTime4 = System.nanoTime();
        max4 = Arrays.stream(irrWrapper).reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
//        max4 = Arrays.stream(irrWrapper).reduce(Integer.MIN_VALUE, Math::max);
        long endTime4 = System.nanoTime();
        long elapsedTime4 = endTime4 - startTime4;
        System.out.println("Stream 결과: " + max4);
        System.out.println("Stream 시간: " + elapsedTime4);

        System.out.println("=== Wrapper Type Test End (Max) ===");
        System.out.println();

        System.out.println("=== Wrapper Type Test Start (add) ===");

        ArrayList<Integer> intList1 = new ArrayList<>();
        startTime1 = System.nanoTime();
        for (int i = 0; i < length; i++) {
            intList1.add(i); // 자동으로 int가 Integer로 변환됨 (오토박싱)
        }
        endTime1 = System.nanoTime();
        elapsedTime1 = endTime1 - startTime1;
        System.out.println("For문 시간: " + elapsedTime1);

        ArrayList<Integer> intList2 = new ArrayList<>();
        startTime2 = System.nanoTime();
        IntStream.range(0, length).forEach(intList2::add);
        endTime2 = System.nanoTime();
        elapsedTime2 = endTime2 - startTime2;

        System.out.println("Stream 시간: " + elapsedTime2);

        System.out.println("=== Wrapper Type Test End (add) ===");

    }

}
