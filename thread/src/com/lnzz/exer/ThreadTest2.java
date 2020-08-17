package com.lnzz.exer;

/**
 * ClassName：ThreadTest2
 *
 * @Author 冷暖自知
 * @Date 2020/8/16 17:09
 * @Version 1.0
 * @Description 例子：创建三个窗口卖票，总票数为100张
 * <p>
 * TODO: 存在线程安全问题，待解决
 */
public class ThreadTest2 {

    public static void main(String[] args) {
        WindowTest1 w1 = new WindowTest1();
        WindowTest1 w2 = new WindowTest1();
        WindowTest1 w3 = new WindowTest1();

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();
    }
}

class WindowTest1 extends Thread {
    private static int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(getName() + ": 卖票，票号为: " + ticket);
                ticket--;
            } else {
                break;
            }
        }

    }
}
