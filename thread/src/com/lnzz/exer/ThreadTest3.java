package com.lnzz.exer;

/**
 * ClassName：ThreadTest3
 *
 * @Author 冷暖自知
 * @Date 2020/8/16 17:23
 * @Version 1.0
 * @Description
 */
public class ThreadTest3 {

    public static void main(String[] args) {
        WindowTest2 w = new WindowTest2();

        Thread w1 = new Thread(w);
        Thread w2 = new Thread(w);
        Thread w3 = new Thread(w);

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();
    }
}

class WindowTest2 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + ": 卖票，票号为: " + ticket);
                ticket--;
            } else {
                break;
            }
        }

    }
}

