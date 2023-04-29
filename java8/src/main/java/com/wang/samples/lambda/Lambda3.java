package com.wang.samples.lambda;

import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author:wsz
 * @Date: 2023/4/29 16:28
 * @Description: java8Api stream流内置函数式接口
 * @Version: 1.0
 * @Since: 1.0
 */
public class Lambda3 {

    public static void main(String[] args) throws Exception {

        //Predicate 接口是只有一个参数的返回布尔类型值的 断言型 接口。
        //该接口包含多种默认方法来将 Predicate 组合成其他复杂的逻辑（比如：与，或，非）
        Predicate<String> predicate= new Predicate<String>() {
            @Override
            public boolean test(String o) {
                return o.length()>0;
            }
        };

        boolean t1 = predicate.test("aaa");
        boolean t2 = predicate.negate().test("aaa");
        System.out.println(t1);
        System.out.println(t2);

        Predicate<Boolean> nonNull = Objects::nonNull;
        //不简化 对比学习
        Predicate<Boolean> isNull =new Predicate<Boolean>() {
            @Override
            public boolean test(Boolean aBoolean) {
                return Objects.isNull(aBoolean);
            }
        };
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        //-------------------------------------------------------------------

        //Function 接口接受一个参数并生成结果。默认方法可用于将多个函数链接在一起（compose, andThen）
        Function<String, Integer> toInteger= Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        String apply = backToString.apply("123");
        System.out.println(apply);

        //-------------------------------------------------------------------

        //Supplier 接口产生给定泛型类型的结果。 与 Function 接口不同，Supplier 接口不接受参数。
        Supplier<Person> personSupplier=new Supplier<Person>() {
            @Override
            public Person get() {
                return new Person();
            }
        };
        //根据方法引用简化
        Supplier<Person> personSupplier1= Person::new;

        //-------------------------------------------------------------------

        // Consumer 接口表示要对单个输入参数执行的操作。
        Consumer<Person> greeter = System.out::println;
        greeter.accept(new Person("w","sz"));


        //-------------------------------------------------------------------
        //Comparator 是老 Java 中的经典接口， Java 8 在此之上添加了多种默认方法
        Comparator<Person> comparator1 = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.firstName.compareTo(o2.firstName);
            }
        };
        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        System.out.println(comparator1.compare(p1,p2));
        System.out.println(comparator1.reversed().compare(p1, p2));


        //-------------------------------------------------------------------
        //Comparator 是老 Java 中的经典接口， Java 8 在此之上添加了多种默认方法

        // Runnable
        Runnable runnable= () -> System.out.println("a");
        runnable.run();

        // Callables
        Callable<UUID> callable = () -> null;
        callable.call();

    }


    interface fun{
        void foo();
    }
}
