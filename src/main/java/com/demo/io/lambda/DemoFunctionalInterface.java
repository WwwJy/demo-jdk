package com.demo.io.lambda;

/**
 * Created by w景洋
 * on 2019/10/17
 */
@FunctionalInterface
interface TestInterface {

    // 函数式接口的定义，有且只有一个抽象方法的接口可以声明为函数式接口
    // 未显式注解FunctionalInterface，并且符合函数式接口定义的接口，编译器会将其看作是函数式接口。
    // 抽象方法如果重写了 java.lang.Object 类中公开的方法，则系统不会给这个接口的抽象函数个数+1。
    // eg: toString 为 Object的公开方法，但是系统不会给本类的抽象函数个数+1，即使抽象函数个数仍然为1

    // 可以进入@FunctionInterface 阅读该注解的相关解释
    void test();

    String toString();
}

public class DemoFunctionalInterface{

    public void myTest(TestInterface testInterface){
        System.out.println("before");
        testInterface.test();
        System.out.println("after");
    }

    // 声明为函数式接口的接口，则可以灵活的使用jdk1.8的新特性 lambda，使得在java中可以类似其他语言可以将函数作为参数进行传递。
    // 但是本质传递的仍然是一个对象, 因为函数段 ()->{} 表示的是一个接口的实现，本例中表示的是 实现了 TestInterface中的test()方法
    public static void main(String[] args) {
        DemoFunctionalInterface d = new DemoFunctionalInterface();
        d.myTest(() -> {
            System.out.println("Hello World");
        });
    }
}