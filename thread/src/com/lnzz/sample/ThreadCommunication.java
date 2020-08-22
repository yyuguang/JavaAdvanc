package com.lnzz.sample;

/**
 * ClassName：Product
 * ThreadCommunication
 *
 * @Author 冷暖自知
 * @Date 2020/8/22 21:41
 * @Version 1.0
 * @Description 线程通信的应用，生产者消费者问题
 * 生产者(Producer)将产品交给店员(Clerk),而消费者(Consumer)从店员处取走产品,
 * 店员一次只能待有固定数量的产品(比如:20),如果生产者试图生产更多的产品,店员
 * 会叫生产者停一下,如果店中有空位放产品了再通知生产者继续生产;如果店中没有产品
 * 了,店员会告诉消费者等一下,如果店中有产品了再通知消费者来取走产品
 * 分析:
 * 1.是否是多线程问题?是,生产者线程,消费者线程
 * 2.是否有共享数据?是,店员(或产品)
 * 3.如何解决线程财安全问题?同步机制有三种方法
 * 4.是否涉及线程的通信?是
 */
public class ThreadCommunication {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        p1.setName("生产者一");

        Consumer c1 = new Consumer(clerk);
        c1.setName("消费者一");
        Consumer c2 = new Consumer(clerk);
        c2.setName("消费者二");

        p1.start();
        c1.start();
        c2.start();
    }
}

/**
 * 店员
 */
class Clerk {

    private int productCount = 0;

    /**
     * 生产产品
     */
    public synchronized void producerProduct() {
        if (productCount < 20) {
            productCount++;
            System.out.println(Thread.currentThread().getName() + " : 开始生产第 " + productCount + " 个产品");

            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 消费产品
     */
    public synchronized void consumerProduct() {
        if (productCount > 0) {
            System.out.println(Thread.currentThread().getName() + " : 开始消费第 " + productCount + " 个产品");
            productCount--;

            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 生产者
 */
class Producer extends Thread {

    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ": 开始生产产品...");
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.producerProduct();
        }
    }
}


/**
 * 消费者
 */
class Consumer extends Thread {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + ": 开始消费产品...");
        while (true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumerProduct();
        }
    }
}
