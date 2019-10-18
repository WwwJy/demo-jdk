package com.demo.io.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class DemoPredicate {

    /**
     * Predicate 的简单使用
     * @param args
     */
    public static void main(String[] args) {
        // predicate 为一个判断公式，传入一个数值，对这个数值判断是否满足某个条件, 然后返回true 或者 false
        Predicate<String> predicate = str -> str.length() > 5;
        System.out.println(predicate.test("hello1"));
        System.out.println("---------------------------------------------");

        DemoPredicate demo6 = new DemoPredicate();
        boolean f = demo6.isReal(59, sc -> sc > 60);
        System.out.println(f);
        System.out.println("---------------------------------------------");
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        // 列表中的元素 大于五且是偶数的数
        demo6.check1(list, item -> item > 5 , item -> item %2 == 0);
        System.out.println("---------------------------------------------");
        // 列表中的元素大于5或者是偶数
        demo6.check2(list, item -> item > 5 , item -> item%2 == 0);
        System.out.println("---------------------------------------------");
    }

    // 动态灵活指定判定条件
    private boolean isReal(int scope, Predicate<Integer> predicate){
        return predicate.test(scope);
    }

    // 逻辑 && 操作
    private void check1(List<Integer> list, Predicate<Integer> predicate1, Predicate<Integer> predicate2){
        list.forEach(item -> {
            if (predicate1.and(predicate2).test(item)){
                System.out.println(item);
            }
        });
    }

    // 逻辑 || 操作
    private void check2(List<Integer> list, Predicate<Integer> predicate1, Predicate<Integer> predicate2){
        list.forEach(item -> {
            if (predicate1.or(predicate2).test(item)){
                System.out.println(item);
            }
        });
    }

    // 逻辑 !操作
    private void check3(List<Integer> list, Predicate<Integer> predicate){
        list.forEach(item -> {
            predicate.negate();
        });
    }
}
