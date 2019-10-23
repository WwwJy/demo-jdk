package com.demo.io.ref;

import com.demo.io.ref.domain.Payer;
import com.demo.io.ref.domain.PayerComparator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by w景洋
 * on 2019/10/18
 */
public class DemoReference {

    public String test(Supplier<String> supplier){
        return supplier.get() + "test";
    }

    public String test2(String str , Function<String,String> func){
        return func.apply(str);
    }

    // 方法引用简单示例
    public static void main(String[] args) {
        Payer p1 = new Payer("zhangsan",60);
        Payer p2 = new Payer("lisi",10);
        Payer p3 = new Payer("wangwu",90);
        Payer p4 = new Payer("zhaoliu",30);

        List<Payer> list = Arrays.asList(p1,p2,p3,p4);

        // lambda表示方式
//        list.sort((param1 , param2) -> Payer.diff(param1,param2));
//        list.forEach(val -> System.out.println(val.getScope()));
        System.out.println("---------------------------");
        // 静态方法引用方式
        list.sort(Payer::diff);
        list.forEach(val -> System.out.println(val.getScope()));
        System.out.println("---------------------------");
        // 引用名::实例方法
        PayerComparator pc = new PayerComparator();
        list.sort(pc::comparatorPayerByName);
        list.forEach(val -> System.out.println(val.getName()));
        System.out.println("---------------------------");
        // 类名::实例方法名
        list.sort(Payer::diff2);
        list.forEach(val -> System.out.println(val.getScope()));
        System.out.println("---------------------------");
        // 构造方法::

        DemoReference demoReference = new DemoReference();
        System.out.println(demoReference.test(String::new));
        System.out.println(demoReference.test2("hello", String::new));
    }
}
