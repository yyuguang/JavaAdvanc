package com.lnzz.thread;

/**
 * ClassName：Thread2
 *
 * @Author 冷暖自知
 * @Date 2020/8/16 15:55
 * @Version 1.0
 * @Description Thread的常用方法
 * 1. start(): 启动当前线程；调用当前线程的run()
 * 2. run(): 通常需要重与 Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3.currentThread(): 静态方法，返回执行当前代码的线程
 * 4.getName(): 获取当前线程的名字
 * 5.setName(): 设置当前线程的名字
 * 6.yield(): 释放当前CPU的执行权
 * 7.join(): 在线程A中调用线程B的join(),此时线程A就进入阻塞状态，知道线程B完全执行完以后，线程A才结束阻塞状态
 * 8.stop(): 已过时。当执行此方法时，强制结束当前线程
 * 9.sleep(): 睡眠。当前线程为阻塞状态
 * 10.isAlive(): 线程是否存活
 * <p>
 * <p>
 * 线程的优先级:
 * 1.
 * MAX_PRIORITY : 10
 * MIN_PRIORITY : 1
 * NORM_PRIORITY : 5
 * 2.如何获取和设置当前线程的优先级
 * getPriority(): 获取线程的优先级
 * setPriority(int p): 设置线程的优先级
 * 说明: 高优先级的线程要抢占低优先级线程pu的执行权。但是只是从概率上讲，高优先级的线程高概率的情况下
 * 被执行。并不意味着只有当高优先级的线程执行完以后，低优先级的线程才执行。
 */
public class Thread2 {
    public static void main(String[] args) {
        //方法一
        ThreadSetName t1 = new ThreadSetName("Thread1: ");

        //方法二
        t1.setName("Thread1: ");
        //设置分线程的优先级
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();

        Thread.currentThread().setName("主线程: ");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
            }
//            if (i == 20) {
//                try {
//                    t1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }

        }
        System.out.println(t1.isAlive());
    }
}

class ThreadSetName extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
//                try {
//                    sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getPriority() + ":" + i);
            }

//            if (i % 20 == 0) {
//                yield();
//            }
        }
    }

    public ThreadSetName(String name) {
        super(name);
    }
}
