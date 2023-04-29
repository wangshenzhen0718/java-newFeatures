package com.wang.samples.lambda;
/**
 * @Author:wsz
 * @Date: 2023/4/29 12:31
 * @Description:接口的默认方法及静态方法
 * @Version: 1.0
 * @Since: 1.0
 */
public class Interface1 {

    public static void main(String[] args){
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a)*100;
            }
        };

        double calculate = formula.calculate(100);
        double sqrt = formula.sqrt(-23);
        int positive = Formula.positive(-3);
        System.out.println(calculate);
        System.out.println(sqrt);
        System.out.println(positive);
    }

    interface Formula {
        static int positive(int a){
            return a>0?a:0;
        }

        double calculate(int a);

        default double sqrt(int a){
            return Math.sqrt(positive(a));
        }

    }

}
