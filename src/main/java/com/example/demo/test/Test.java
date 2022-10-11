package com.example.demo.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author czh
 * @version 1.0
 * @date 2022/10/9 15:25
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.test3();
    }
    public static int m(int a,int b){
        try {
            return a/b;
        } catch (ArithmeticException e) {
            System.out.println("除以0无意义");
            return 0;
        }finally {
            System.out.println("除法结束！");
        }

    }
    public void cat(){
        synchronized(this){
            try {
                wait();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void test2(){
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "a", "b"));
        /*使用hashSet*/
        Set<String> strings = new HashSet<>(list);
        list.clear();
        list.addAll(strings);
        System.out.println(list);
        /*双重for循环*/
        List<String> list1 = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "a", "b"));
        for (int i = 0; i < list1.size(); i++) {
            String s = list1.get(i);
            for (int j = i+1; j <list1.size(); j++) {
                if(s.equals(list1.get(j))){
                    list1.remove(j);
                }
            }
        }
        System.out.println(list1);
        /*list的contains方法 判断对象是否存在列表*/
        List<String> list2 = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "a", "b"));
        ArrayList<String> result = new ArrayList<>();
        for(String s:list2){
            if(!result.contains(s)){
                result.add(s);
            }
        }
        list2.clear();
        list2.addAll(result);
        System.out.println(list2);
    }
    public void test3(){
        Integer i=8;
        System.out.println(i);
    }
}



