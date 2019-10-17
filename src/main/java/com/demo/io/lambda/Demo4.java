package com.demo.io.lambda;

import java.util.function.Function;

/**
 * Created by w景洋
 * on 2019/10/17
 */
public class Demo4 {

    public static void main(String[] args) {
        Demo4 d4 = new Demo4();
        int result = d4.calc(3, val -> {
           return 2*val;
        });
        System.out.println(result);
    }

    // 普通函数使用lambda
    public int calc(int a, Function<Integer, Integer> func){
        int result = func.apply(a);
        return result;
    }
}
