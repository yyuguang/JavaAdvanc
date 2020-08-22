package com.lnzz.thread;

/**
 * ClassName：Thread4
 *
 * @Author 冷暖自知
 * @Date 2020/8/22 17:33
 * @Version 1.0
 * @Description 线程通信，打印100个数，两个线程交替打印
 * 涉及到的三个方法:
 * wait():一且执行此方法,当前线程就进入阻塞状态,并释放同步监视器。
 * notify():一旦执行此方法,就会唤醒wait()的一个线程。如果有多个线程被wait,就唤醒优先级高的那个
 * notifyAll():唤醒所有被wait()的线程
 */
public class Thread4 {
    public static void main(String[] args) {
        MyTest4 t = new MyTest4();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();
    }
}

class MyTest4 implements Runnable {
    private int number = 1;

    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {

                obj.notify();

                if (number <= 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " : " + number);
                    number++;

                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}
