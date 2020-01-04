package com.demo.io.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyComparatorTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("nihao","hello","world","welcome");

        // 先进行一次比较，单词长度大的排在后面。前三个一致，没有比较出结果，最后反转，welocome排到了前面
        // 对于长度一致的单词进行第二次比较，根据小写字母的排序，最后再反转。
        Collections.sort(list, Comparator.comparingInt(String::length).reversed()
                .thenComparing(Comparator.comparing(String::toLowerCase,Comparator.reverseOrder())));

        System.out.println(list);
    }
}
