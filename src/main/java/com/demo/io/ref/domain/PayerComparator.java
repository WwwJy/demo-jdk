package com.demo.io.ref.domain;

/**
 * Created by w景洋
 * on 2019/10/18
 */
public class PayerComparator {

    public int comparatorPayerByName(Payer p1, Payer p2){
        return p1.getName().compareToIgnoreCase(p2.getName());
    }
}
