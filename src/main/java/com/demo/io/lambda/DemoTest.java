package com.demo.io.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author wJingYang
 * @Date 2019/12/31
 */
public class DemoTest {

    List<String> newList = Arrays.asList("1","2","3","4");
    List<String> oldList = Arrays.asList("1","2","3");
    List<String> delList = new ArrayList<>();

    public void test(){
        if (newList.size() != 0){
            if (oldList.size() == 0){
                System.out.println("添加所有元素");
            }else {
                newList.forEach(item -> {
                    if (!oldList.contains(item)){
                        System.out.println("添加新元素");
                    }else{
                        delList.add(item);
                    }
                });
            }
        }

        // delList = 要删除的元素
    }
}
