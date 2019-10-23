package com.demo.io.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by w景洋
 * on 2019/10/22
 */
public class Demo {

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("Hi","Hello","你好");
        List<String> list2 = Arrays.asList("zhangsan","wangwu","zhaoli","lisi");

        List<String> list = list1
                .stream()
                .flatMap(item1 -> list2
                        .stream()
                        .map(item2 -> item1 + " " + item2))
                .collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}
