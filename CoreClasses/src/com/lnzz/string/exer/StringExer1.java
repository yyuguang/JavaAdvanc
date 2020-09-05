package com.lnzz.string.exer;

import org.junit.Test;

/**
 * ClassName：StringExer1
 *
 * @Author 冷暖自知
 * @Date 2020/8/24 21:39
 * @Version 1.0
 * @Description String面试题
 */
public class StringExer1 {

    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringExer1 ex = new StringExer1();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str);
        System.out.println(ex.ch);
    }


}
