package com.demo.io.lambda;

import javax.swing.*;

public class Demo1 {
    /**
     * lambda的示例
     * @param args
     */
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
