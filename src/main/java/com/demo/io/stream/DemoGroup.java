package com.demo.io.stream;

import com.demo.io.stream.domain.Teacher;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by w景洋
 * on 2019/10/23
 */
public class DemoGroup {

    // 介绍 collect 的 group by 和 partition by
    // 区别: group 按照关键字分组，可以有多个组别
    //       partition by 只分为两组, true 或者false
    public static void main(String[] args) {
        Teacher t1 = new Teacher("zhangsan",100,25);
        Teacher t2 = new Teacher("lisi",90,30);
        Teacher t3 = new Teacher("wangwu",90,25);
        Teacher t4 = new Teacher("zhaoliu",80,40);
        List<Teacher> list = Arrays.asList(t1,t2,t3,t4);

        // Map<String, List<Teacher>> map = list.stream().collect(Collectors.groupingBy(Teacher::getName));
        // Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(Teacher::getScope, Collectors.counting()));
//        Map<String, Double> map = list.stream().collect(Collectors.groupingBy(Teacher::getName, Collectors.averagingDouble(Teacher::getScope)));
        Map<Boolean, List<Teacher>> map = list.stream().collect(Collectors.partitioningBy(item -> item.getScope() >= 90));
        System.out.println(map);
    }
}
