package com.lnzz.thread;

/**
 * ClassName：Thread1
 *
 * @Author 冷暖自知
 * @Date 2020/8/16 0:22
 * @Version 1.0
 * @Description 多线程的创建，方式一：继承于Thread类
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread类的run()
 * 3.创建Thread类的子类的对象
 * 4.通过此对象调用start()
 * <p>
 * 例子：遍历100以内的所有偶数
 */
public class Thread1 {
    public static void main(String[] args) {
        //3.创建Thread类的子类的对象
        MyThread thread = new MyThread();
        //4.通过此对象调用start() ①启动当前线程 ②调用当前线程的run()
        thread.start();
        /**
         * 问题一：不能直接调用run()方法
         * thread.run()
         * 直接调用run()方法，对象调方法，根本没有多线程
         */

        /**
         * 问题二：想多个线程调用，不能直接再次调用 start()方法，会抛出IllegalThreadStateException异常
         * 解决办法：重新创建一个线程对象
         */
        MyThread thread2 = new MyThread();
        thread2.start();

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i + "********************main()***********************");
            }
        }
    }
}

/**
 * 1.创建一个继承于Thread类的子类
 */
class MyThread extends Thread {
    /**
     * 2.重写Thread类的run()
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
