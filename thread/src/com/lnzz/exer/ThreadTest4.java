package com.lnzz.exer;

/**
 * ClassName：ThreadTest4
 *
 * @Author 冷暖自知
 * @Date 2020/8/17 21:26
 * @Version 1.0
 * @Description 使用同步代码块解决实现Runnable()接口的方式的线程安全问题
 * 存在问题：
 * 1.出现重票，错票，出现了线程安全问题
 * 2.问题出现的原因：当某个线程操作车票的过程中,尚未操作完成时,其他线程参与进来,也操作车票
 * 3.如何解决：加锁，当一个线程A在操作ticket是，其他线程不能参与进来，直到线程A操作完ticket是，其他线程才可以操作ticket
 * 这种情况即使线程A出现阻塞，也不能被改变
 * 4.Java中，通过同步机制，解决线程的安全问题
 *
 * 方式一：
 * synchronized(同步监视器){
 *     //需要被同步的代码
 * }
 * 说明：1.操作共享数据的代码，即为需要同步的代码
 *      2.共享数据：多个线程共同操作的变量，即ticket就是共享数据
 *      3.同步监视器：俗称，锁。任何一个类的对象，都可以充当锁
 *          要求：多个线程必须要共用同一把锁
 *
 * 方式二：同步方法
 *
 * 5.同步的方式，解决了线程安全问题 --好处
 *   操作同步代码是，只能有一个线程参与，其他线程等待。相当于是一个单线程的过程，效率低 --局限性
 *
 */
public class ThreadTest4 {
    public static void main(String[] args) {
        WindowTest3 w = new WindowTest3();

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

class WindowTest3 implements Runnable {
    private int ticket = 100;

    private Object object = new Object();

    @Override
    public void run() {
        while (true) {
//            synchronized (object){
            synchronized (this){
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ": 卖票，票号为: " + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }

    }
}


