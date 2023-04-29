package com.wang.samples.lambda;

import java.util.HashMap;
import java.util.function.BiConsumer;
/**
 * @Author:wsz
 * @Date: 2023/4/29 18:13
 * @Description:接受两个输入参数没有返回值
 * @Version: 1.0
 * @Since: 1.0
 */
public class Lambda5 {

    //Pre-Defined Functional Interfaces
    public static void main(String... args) {

        //BiConsumer Example
        BiConsumer<String,Integer> printKeyAndValue
                = (key,value) -> System.out.println(key+"-"+value);

        printKeyAndValue.accept("One",1);
        printKeyAndValue.accept("Two",2);

        System.out.println("##################");

        //Java Hash-Map foreach supports BiConsumer
        HashMap<String, Integer> dummyValues = new HashMap<>();
        dummyValues.put("One", 1);
        dummyValues.put("Two", 2);
        dummyValues.put("Three", 3);

        dummyValues.forEach((key,value) -> System.out.println(key+"-"+value));

    }
}