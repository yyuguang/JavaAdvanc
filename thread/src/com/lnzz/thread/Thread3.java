package com.lnzz.thread;

/**
 * ClassName：Thread3
 *
 * @Author 冷暖自知
 * @Date 2020/8/16 17:16
 * @Version 1.0
 * @Description 创建多线程方式二：实现Runnable接口
 * 1.创建一个实现了 Runnable接口的类
 * 2.实现类去实现 Runnable中的抽象方法:run()
 * 3.创建实现类的对象
 * 4.将此对象作为参数传诺到 Thread类的构造器中,创建 Thread类的对象
 * 5.通过Thread类的对象调用 start()
 * <p>
 * 比较两种线程的创建方式
 * 开发中: 优先进择实现 Runnable接口的方式
 * 原因:
 * 1.实现的方式没有类的单继承性的局限性
 * 2.实现的方式更适合来处理多个线程有共享数据的情况。
 * <p>
 * 联系: public class Thread implements Runnable
 * 相同点:两种方式都需要重写run(),将线程要执行的代码重写在run()中
 */
public class Thread3 {
    public static void main(String[] args) {
        MyThread3 thread = new MyThread3();
        Thread t1 = new Thread(thread);
        t1.start();

        Thread t2 = new Thread(thread);
        t2.start();
    }
}

class MyThread3 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
