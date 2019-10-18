package com.demo.io.lambda;

import java.util.Arrays;
import java.util.List;

public class Demo2 {
    /**
     * lambda的函数结构简单介绍
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        // 常规for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("------------------------");
        // 增强for循环
        for (Integer i : list){
            System.out.println(i);
        }
        System.out.println("------------------------");
        // lambda for循环
        // forEach 为 Iterable 接口中的一个默认实现。
        // 从jdk1.8开始，接口可以拥有方法实现，接口中定义的实现，我们称之为默认实现，用关键字 default标示。

        // 通过 lambda表达式实现Consumer的accept()方法
        list.forEach(e -> {
            System.out.println(e);
        });
        // 通过函数引用实现Consumer的accept()方法
        System.out.println("------------------------");
        list.forEach(System.out::println);
    }
}
