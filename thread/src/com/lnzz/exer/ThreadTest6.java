package com.lnzz.exer;

/**
 * ClassName：ThreadTest6
 *
 * @Author 冷暖自知
 * @Date 2020/8/22 15:25
 * @Version 1.0
 * @Description 使用同步方法解决实现Runnable()接口的方式的线程安全问题
 * 方式二：同步方法
 * 如果操作共享数据的代码完整声明在一个方法中，我们不妨将此方法生命同步的
 */
public class ThreadTest6 {
    public static void main(String[] args) {
        WindowTest6 w = new WindowTest6();

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

class WindowTest6 implements Runnable {
    private int ticket = 100;


    @Override
    public void run() {
        while (true) {
            show();
        }

    }

    private synchronized void show() {
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



