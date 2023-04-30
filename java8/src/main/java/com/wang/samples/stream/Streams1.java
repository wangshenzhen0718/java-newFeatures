package com.wang.samples.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
/**
 * @Author:wsz
 * @Date: 2023/4/30 21:31
 * @Description:Streams基本用法
 * @Version: 1.0
 * @Since: 1.0
 */
public class Streams1 {
    public static void main(String[] args){
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        // filtering
        stringCollection
                .stream()
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);
        System.out.println("---------------------------------------------");
        //aaa2 aaa1

        // sorting
        stringCollection
                .stream()
                .sorted()
                .filter(s -> s.startsWith("a"))
                .forEach(System.out::println);
        System.out.println("---------------------------------------------");

        //aaa2 aaa1


        // mapping
        stringCollection
                .stream()
                .map(a->a.toUpperCase())
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        System.out.println("---------------------------------------------");
        /*DDD2
        DDD1
        CCC
        BBB3
        BBB2
        BBB1
        AAA2
        AAA1*/

        boolean b = stringCollection
                .stream()
                .anyMatch(s -> s.startsWith("a"));
        System.out.println(b);
        //true

        boolean allStartsWithA = stringCollection
                .stream()
                .allMatch((s) -> s.startsWith("a"));

        System.out.println(allStartsWithA);      // false

        boolean noneStartsWithZ = stringCollection
                .stream()
                .noneMatch((s) -> s.startsWith("z"));

        System.out.println(noneStartsWithZ);      // true

        System.out.println("---------------------------------------------");

        long startsWithB  = stringCollection
                .stream()
                .filter((s) -> s.startsWith("b"))
                .count();

        System.out.println(startsWithB);
        System.out.println("---------------------------------------------");
        //3


        Optional<String> reduced = stringCollection
                .stream()
                .sorted(Comparator.naturalOrder())
                .reduce((s, s2) -> s + "#" + s2);
        reduced.ifPresent(System.out::println);
        System.out.println("---------------------------------------------");
        //aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2



    }
}
