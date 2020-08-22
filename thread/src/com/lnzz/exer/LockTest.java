package com.lnzz.exer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName：LockTest
 *
 * @Author 冷暖自知
 * @Date 2020/8/22 17:06
 * @Version 1.0
 * @Description 解决线程安全问题的方式三：Lock锁 ---JDK5.0新增
 */
public class LockTest {
    public static void main(String[] args) {
        WindowLockTest w = new WindowLockTest();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}

class WindowLockTest implements Runnable {
    private int ticket = 100;

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ": 售票，票号为 : " + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
