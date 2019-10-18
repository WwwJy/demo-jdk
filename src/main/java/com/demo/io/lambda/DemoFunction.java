package com.demo.io.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class DemoFunction {

    /**
     * 简单运用Function<T,R>
     * @param args
     */
    public static void main(String[] args) {
        DemoFunction d4 = new DemoFunction();
        int result = d4.calc0(3, val -> {
           return 2*val;
        });
        System.out.println(result);
        System.out.println("--------------------------------------");

        // 先执行 func2 也就是乘法。 再执行func1 ,
        int number1 = d4.calc1(5,value -> value + value, value -> value * value);
        System.out.println(number1);

        // 先执行 func1 也就是加法。 再执行func2 ,
        int number2 = d4.calc2(5,value -> value + value, value -> value * value);
        System.out.println(number2);
        System.out.println("--------------------------------------");

        int number3 = d4.calc3(2,4, (value1, value2) -> value1 + value2, value -> value * value);
        System.out.println(number3);
    }

    // 普通函数使用lambda
    public int calc0(int a, Function<Integer, Integer> func){
        int result = func.apply(a);
        return result;
    }

    // Function<T,R> 的 compose和andThen可以串联的执行一列函数，两者的运行模式相反
    // 先将整数a 经过 func2的运算后，再将func2的返回值传入到func1中再次运算。
    public int calc1(int a, Function<Integer, Integer> func1 , Function<Integer, Integer> func2){
        return func1.compose(func2).apply(a);
    }

    // 先将整数a 经过func1的运算后，再将func1的返回值传入到func2中再次运算。
    public int calc2(int a, Function<Integer, Integer> func1 , Function<Integer, Integer> func2){
        return func1.andThen(func2).apply(a);
    }

    // 传递两个参数的Function<T,R>.
    // BiFunction 没有compose方法，因为compose先执行传进来的目标函数，最终只会得到一个返回值，而BiFunction需要目标给定两个参数
    public int calc3(int a, int n, BiFunction<Integer,Integer,Integer> bfc, Function<Integer,Integer> func){
        return bfc.andThen(func).apply(a,n);
    }
}
