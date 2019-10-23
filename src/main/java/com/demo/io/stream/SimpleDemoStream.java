package com.demo.io.stream;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * Created by w景洋
 * on 2019/10/21
 */
public class SimpleDemoStream {

    /**
     * stream 简单的介绍
     * @param args
     */
    public static void main(String[] args) {
        SimpleDemoStream simpleDemoStream = new SimpleDemoStream();
//        simpleDemoStream.task0();
//        simpleDemoStream.task1();
//        simpleDemoStream.task2(false);
//        simpleDemoStream.task3();
    }

    private void task0(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        System.out.println(
                list.stream()
                .map(i -> i*2)
                .reduce(0,Integer::sum)
        );
    }
    private void task1(){
        System.out.println(
                Stream.iterate(1,item -> item+2)
                .limit(6)
                .filter(item -> item > 2)
                .mapToInt(item -> item=item*2)
                .skip(2)
                .limit(2)
                .sum());
    }

    // 串行流，一个线程执行所有操作, 执行效率低，但严格排序
    // 并行流, 多个线程执行所有操作, 执行效率高，排序混乱
    private void task2(boolean isParallel){
        List<String> list = new ArrayList<>();
        for (int i = 0; i<20; i++){
            list.add(UUID.randomUUID().toString());
        }
        System.out.println("开始排序");
        long startTime = System.nanoTime();
        if (isParallel){
            // 并行流
            list.parallelStream().sorted().forEach(System.out::println);
        }else {
            // 串行流
            list.stream().sorted().forEach(System.out::println);
        }
        long endTime = System.nanoTime();
        long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
        System.out.println("排序耗时: " + millis);
    }

    // 思考System.out.println(item);会打印出什么? 运行结果是否一致
    // 尝试修改 list中元素的长度，思考为什么会出现这样的现象
    private void task3(){
        List<String> list = Arrays.asList("hello","world","hello world");
        list.stream()
                // 将数组映射为字符串长度的数组
                .mapToInt(item -> {
                    int length = item.length();
                    System.out.println(item);
                    return length;
                })
                // 查询长度==5的字符串数组
                .filter(length -> length == 5)
                // 找到第一个元素
                .findFirst()
                // 第一个元素存在就打印出来
                .ifPresent(System.out::println);
    }
    // 注: 流是存在短路运算的,其理解和操作符 || 或者 && 意思相同。
    // findFirst()函数即是一个短路操作，当找到第一个符合规则的元素，则不再继续往下执行。

}
