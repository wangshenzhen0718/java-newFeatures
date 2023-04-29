package com.wang.samples.lambda;
/**
 * @Author:wsz
 * @Date: 2023/4/29 14:20
 * @Description:方法引用 让代码更加简洁
 * @Version: 1.0
 * @Since: 1.0
 */
public class Lambda2 {
    public static void main(String[] args){

        //实现函数式接口 原生
        Converter<String,Integer> converter=new Converter<String, Integer>() {
            @Override
            public Integer convert(String from) {
                return Integer.valueOf(from);
            }
        };
        //实现函数式接口 通过Lambda简化
        Converter<String,Integer> converter1= from -> Integer.valueOf(from);
        Integer convert = converter1.convert("123");
        System.out.println(convert);

        // 方法引用
        //当我们需要使用Lambda表达式来实现一个函数式接口的抽象方法时，已经有存在的类实现了我们需要的功能方法
        // 这时我们完全没必要再造一个实现方法，可以直接用Lambda表达式调用这个方法来实现，虽然这样子实现可以
        // 但是很冗余，此时使用方法引用就很简洁清晰，可读性更高。
        Converter<String,Integer> converter2= Integer::valueOf;
        Integer convert2 = converter2.convert("123");
        System.out.println(convert2);


        Something something = new Something();
        Converter<String,String> stringConverter= something::startsWith;
        String converted =  stringConverter.convert("Java");
        System.out.println(converted);


        //普通方式
        PersonFactory<Person> personFactory = new PersonFactory<Person>() {
            @Override
            public Person create(String firstName, String lastName) {
                return new Person(firstName,lastName);
            }
        };

        //Lambda方式
        PersonFactory<Person> personFactory1 = (firstName, lastName) -> new Person(firstName,lastName);

        //构造方法引用方式
        PersonFactory<Person> personFactory2 = Person::new;

        Person person = personFactory2.create("w", "sz");
        System.out.println(person);

        //数组的构造器引用
        //数组也是Object的子类对象，所以同样是具有构造器的，实质也是构造器的引用，但是语法格式有些不同
        // 数组的构造器引用格式为：类型[]::new，其中这个类型可以是基本类型也可以是类。
        //Lambda方式
        ArrayBuilder arrayBuilder = length -> new int[length];

        int[] ints = arrayBuilder.buildArray(5);

        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }


        //Lambda方式
        ArrayBuilder arrayBuilder1 = int[]::new;
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i*2;
        }
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }


    }
    //自定义函数式接口
    @FunctionalInterface
    public static interface Converter<F, T> {
        T convert(F from);
    }

    interface PersonFactory<P extends Person> {
        P create(String firstName, String lastName);
    }

    interface ArrayBuilder{
        int[] buildArray(int length);

    }

    //自定义一个方法 参数为String,返回值也是String
    static class Something {
        String startsWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }

}
