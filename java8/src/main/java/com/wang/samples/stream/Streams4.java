package com.wang.samples.stream;

import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * @Author:wsz
 * @Date: 2023/4/30 22:04
 * @Description:for循环遍历也能用stream替代
 * @Version: 1.0
 * @Since: 1.0
 */
public class Streams4 {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 1) {
                System.out.println(i);
            }
        }
        System.out.println("----------------------------------------------");

        IntStream.range(0,10).forEach(i ->{
            if (i%2==1){
                System.out.println(i);
            }
        });


        System.out.println("----------------------------------------------");
        IntStream.range(0,10).filter(i->i%2==1).forEach(System.out::println);

        System.out.println("----------------------------------------------");

        //reduced求和
        OptionalInt reduced1 =
                IntStream.range(0, 10)
                        .reduce((a, b) -> a + b);
        System.out.println(reduced1.getAsInt());


        System.out.println("----------------------------------------------");
        int reduced2 =
                IntStream.range(0, 10)
                        .reduce(7, (a, b) -> a + b);
        System.out.println(reduced2);


    }
}
