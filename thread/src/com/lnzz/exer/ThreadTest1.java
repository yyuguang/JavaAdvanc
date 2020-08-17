package com.lnzz.exer;

/**
 * ClassName：ThreadTest1
 *
 * @Author 冷暖自知
 * @Date 2020/8/16 0:39
 * @Version 1.0
 * @Description 练习：创建两个分线程，其中一个线程遍历100以内的偶数，另一个线程遍历100以内的奇数
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        //方法一：创建两个线程
//        MyThread1 thread1 = new MyThread1();
//        MyThread2 thread2 = new MyThread2();
//
//        thread1.start();
//        thread2.start();

        //方法二：匿名内部类
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0) {
                        System.out.println("偶数: " + i);
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0) {
                        System.out.println("奇数: " + i);
                    }
                }
            }
        }.start();
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println("偶数: " + i);
            }
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println("奇数: " + i);
            }
        }
    }
}