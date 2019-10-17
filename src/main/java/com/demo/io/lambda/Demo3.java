package com.demo.io.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by w景洋
 * on 2019/10/17
 */
public class Demo3 {
    public static void main(String[] args) {
        // 要求： 把list中的字符串变成大写，并打印出来
        List<String> list = Arrays.asList("hello","world","hello world");
        // 利用lambda和stream的形式操作
        list.stream()
                .map(item -> item.toUpperCase())
                .forEach(item -> System.out.println(item));
        System.out.println("-------------------------------------------");
        // 利用函数引用和stream的形式操作
        // targetClass :: function , ::符号前面表示要调用的方法的类，后面表示类中的方法。
        list.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println("-------------------------------------------");
        List<Integer> names = Arrays.asList(1,3,5,7,2,3,5,9);
        Collections.sort(names,(o1,o2) ->{
            return o2.compareTo(o1);
        });
        System.out.println(names);
    }
}
