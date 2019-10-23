package com.demo.io.ref;

import com.demo.io.ref.domain.DemoInterface1Impl;

/**
 * Created by w景洋
 * on 2019/10/21
 */
public class DemoTest extends DemoInterface1Impl implements DemoInterface2{

    // 当两个接口同时有相同名字的默认函数时, 实现类需要重写相同名字的方法。
    // 当继承类和接口默认函数函数名相同时，JVM优先选择使用继承类的方法
    public static void main(String[] args) {
        DemoTest demoTest = new DemoTest();
        demoTest.myTest();
    }
}
