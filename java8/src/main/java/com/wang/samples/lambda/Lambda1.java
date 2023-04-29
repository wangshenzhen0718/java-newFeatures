package com.wang.samples.lambda;

import java.util.*;


/**
 * @Author:wsz
 * @Date: 2023/4/29 12:31
 * @Description:Lambda 表达式
 * @Version: 1.0
 * @Since: 1.0
 */
public class Lambda1 {

    public static void main(String[] args){
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        //看看老版本的 Java 中是如何排列字符串的
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });

        //Java 8 提供了更简洁的语法，lambda 表达式
        Collections.sort(names, (a, b) -> a.compareTo(b));

        //更加简化
        names.sort(Collections.reverseOrder());


        List<String> names2 = Arrays.asList("peter", null, "anna", "mike", "xenia");
        names2.sort(Comparator.nullsLast(String::compareTo));
        System.out.println(names2);

        List<String> names3 = null;
        Optional.ofNullable(names3).ifPresent(strings -> strings.sort(Comparator.naturalOrder()));

        System.out.println(Optional.ofNullable(names3));
        System.out.println(names3);





    }



}
