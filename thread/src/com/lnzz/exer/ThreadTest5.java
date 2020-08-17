package com.lnzz.exer;

/**
 * ClassName：ThreadTest5
 *
 * @Author 冷暖自知
 * @Date 2020/8/17 22:37
 * @Version 1.0
 * @Description 使用同步代码块解决继承Thread类的方式的线程安全问题
 */
public class ThreadTest5 {
    public static void main(String[] args) {
        WindowTest4 w1 = new WindowTest4();
        WindowTest4 w2 = new WindowTest4();
        WindowTest4 w3 = new WindowTest4();

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();
    }
}

class WindowTest4 extends Thread {
    private static int ticket = 100;
    private static Object object = new Object();

    @Override
    public void run() {
        while (true) {
            //正确的
//            synchronized (object) {
            synchronized (WindowTest4.class) {
                //错误的方式：this代表w1,w2,w3三个对象
//                synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + ": 卖票，票号为: " + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }

    }
}

