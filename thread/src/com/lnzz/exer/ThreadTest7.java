package com.lnzz.exer;

/**
 * ClassName：ThreadTest7
 *
 * @Author 冷暖自知
 * @Date 2020/8/22 15:53
 * @Version 1.0
 * @Description 使用同步方法解决继承Thread类的方式的线程安全问题
 * <p>
 * 关于同步方法的总结：
 * 1.同步方法仍然涉及到同步监视器,只是不需要我们显式的声明
 * 2.非静态的同步方法,同步监视器是:ths
 * 静态的同步方法,同步监视器是:当前类本身
 */
public class ThreadTest7 {
    public static void main(String[] args) {
        WindowTest7 w1 = new WindowTest7();
        WindowTest7 w2 = new WindowTest7();
        WindowTest7 w3 = new WindowTest7();

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();
    }
}

class WindowTest7 extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            show();
        }
    }

    private static synchronized void show() {
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": 卖票，票号为: " + ticket);
            ticket--;
        }
    }
}

