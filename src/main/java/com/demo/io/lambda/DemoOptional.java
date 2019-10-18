package com.demo.io.lambda;

import com.demo.io.lambda.domain.ClassRoom;
import com.demo.io.lambda.domain.Student;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class DemoOptional {

    /**
     * Optional的简单使用
     * Optional 推荐使用lambda表达式简化写法
     *
     * @param args
     */
    public static void main(String[] args) {
        Student st1 = new Student("张三",60);
        Student st2 = new Student("张二",80);
        List<Student> list = Arrays.asList(st1,st2);
        ClassRoom room = new ClassRoom();
        room.setName("计算机科学与技术");
        room.setList(list);

        // 判断列表是否为空，为空则返回空列表，否则返回原值
        Optional<ClassRoom> opt = Optional.ofNullable(room);
        System.out.println(opt.map(ClassRoom::getList).orElse(Collections.emptyList()));
    }
}
