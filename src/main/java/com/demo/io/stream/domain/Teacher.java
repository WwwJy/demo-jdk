package com.demo.io.stream.domain;

/**
 * Created by w景洋
 * on 2019/10/23
 */
public class Teacher {
    private String name;
    private int scope;
    private int age;

    public Teacher(String name, int scope, int age) {
        this.name = name;
        this.scope = scope;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
