package com.demo.io.lambda;

import com.demo.io.lambda.domain.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class DemoBiFunction {

    public static void main(String[] args) {
        Student student1 = new Student("张三",60);
        Student student2 = new Student("李四",70);
        Student student3 = new Student("王五",80);

        List<Student> list = Arrays.asList(student1,student2,student3);
        DemoBiFunction d5 = new DemoBiFunction();
        List<Student> res1 = d5.getStudentByName("张三",list);
        res1.forEach(student -> System.out.println(student.getName()));
        System.out.println("---------------------------------------------");

        List<Student> res2 = d5.getStudentByScope(60,list);
        res2.forEach(student -> System.out.println(student.getScope()));
        System.out.println("---------------------------------------------");

        List<Student> res3 = d5.getStudentByScope(60,list, (sc,ls)->{
            return ls.stream().filter(student -> student.getScope() <= sc).collect(Collectors.toList());
        });
        res3.forEach(student -> System.out.println(student.getScope()));
    }

    // 通过steam 过滤出符合条件的元素，再组合成集合
    private List<Student> getStudentByName(String keyName, List<Student> list){
        return list.stream()
                .filter(student -> student.getName().equals(keyName))
                .collect(Collectors.toList());
    }

    // 通过biFunction的形式得到结果
    private List<Student> getStudentByScope(Integer scope, List<Student> list){
        BiFunction<Integer, List<Student>, List<Student>> biFunction = (studentScope, studentList) -> {
            return studentList.stream().filter(student -> student.getScope() > studentScope).collect(Collectors.toList());
        };
        return biFunction.apply(scope,list);
    }

    // 由调用者灵活指定BiFunction 执行内容
    private List<Student> getStudentByScope(Integer scope,List<Student>list,BiFunction<Integer,List<Student>,List<Student>> biFunction){
        return biFunction.apply(scope,list);
    }
}
