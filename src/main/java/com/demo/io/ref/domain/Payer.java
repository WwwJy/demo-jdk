package com.demo.io.ref.domain;

/**
 * Created by w景洋
 * on 2019/10/18
 */
public class Payer {

    private String name;
    private int scope;

    public Payer(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public static int diff(Payer p1 , Payer p2) {
        return p1.getScope() - p2.getScope();
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
}
