package com.wang.samples.stream;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author:wsz
 * @Date: 2023/4/30 22:44
 * @Description:stream求平均值
 * @Version: 1.0
 * @Since: 1.0
 */
public class Streams6 {

    public static void main(String[] args) throws IOException {
        test1();
        test2();
        test3();
        test4();
    }

    private static void test4() {
        Stream
            .of(new BigDecimal("1.2"), new BigDecimal("3.7"))
            .mapToDouble(BigDecimal::doubleValue)
            .average()
            .ifPresent(System.out::println);
    }

    private static void test3() {
        IntStream
            .range(0, 10)
            .average()
            .ifPresent(System.out::println);
    }

    private static void test2() {
        IntStream
            .builder()
            .add(1)
            .add(3)
            .add(5)
            .add(7)
            .add(11)
            .build()
            .average()
            .ifPresent(System.out::println);

    }

    private static void test1() {
        int[] ints = {1, 3, 5, 7, 11};
        Arrays
            .stream(ints)
            .average()
            .ifPresent(System.out::println);
    }
}
