package com.demo.io.lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by w景洋
 * on 2019/10/17
 */
public class Demo1 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("My JFrame");
        JButton jButton = new JButton("My JButton");
        // 以lambda表示的形式替换匿名内部类的形式。
        // e的类型会在编译的时候，由编译器进行类型推断,判断出e = ActionEvent;
        jButton.addActionListener(e -> {
            System.out.println("hello world");
        });

        jFrame.add(jButton);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
