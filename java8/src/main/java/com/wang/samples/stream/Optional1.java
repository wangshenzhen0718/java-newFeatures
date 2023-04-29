package com.wang.samples.stream;

import java.util.Optional;

/**
 * @Author:wsz
 * @Date: 2023/4/29 18:15
 * @Description: Optional.of() 使用
 * @Version: 1.0
 * @Since: 1.0
 */
public class Optional1 {
    public static void main(String[] args){
        //of()：为非null的值创建一个Optional
        Optional<String> optional = Optional.of("bam");
        // isPresent()： 如果值存在返回true，否则返回false
        System.out.println(optional.isPresent());
        //get()：如果Optional有值则将其返回，否则抛出NoSuchElementException
        System.out.println(optional.get());
        //orElse()：如果有值则将其返回，否则返回指定的其它值
        System.out.println(optional.orElse("fallback"));
        //ifPresent()：如果Optional实例有值则为其调用consumer，否则不做处理
        optional.ifPresent(s -> System.out.println(s.charAt(0)));
    }
}
