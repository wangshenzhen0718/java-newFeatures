package com.wang.samples.stream;

import java.util.ArrayList;
import java.util.List;
/**
 * @Author:wsz
 * @Date: 2023/4/30 21:35
 * @Description:Streams不影响原有数据
 * @Version: 1.0
 * @Since: 1.0
 */
public class Streams2 {

    public static void main(String[] args) {

        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");


        // sorting

        stringCollection
                .stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println(stringCollection);

        

    }

}