package com.example.demo.rule.demo;



import com.example.demo.rule.RuleData;
import com.example.demo.rule.RuleExecutor;
import com.example.demo.rule.RuleKey;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zhenghongquan
 * @Program: wos-api
 * @Description:
 * @date 2022-08-01 13:36
 */
public class Test {
    public static void main(String[] args) {

        // 创建一个动态数组
        ArrayList<String> sites = new ArrayList<>();

        sites.add("1");
        sites.add("2");
        sites.add("3");

        System.out.println("ArrayList 1: " + sites);

        // 创建另一个动态数组
        ArrayList<String> sites2 = new ArrayList<>();

        // 往动态数组中添加元素
        sites2.add("1");
        sites2.add("4");
        System.out.println("ArrayList 2: " + sites2);

        // 检查动态数组1是否包含动态数组2
        boolean result1 = sites.containsAll(sites2);
        System.out.println("ArrayList 1 包含了 ArrayList 2 的所有元素: " + result1);

        // 检查数组2是否包含数组1
        boolean result2 = sites2.containsAll(sites);
        System.out.println("ArrayList 2 包含了 ArrayList 1 的所有元素: " + result2);

    }
}
