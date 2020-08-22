package com.lnzz.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName：Thread6
 *
 * @Author 冷暖自知
 * @Date 2020/8/22 23:29
 * @Version 1.0
 * @Description 创建多线程的方式四：使用线程池
 */
public class Thread6 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

        //适用于Runnable
        service.execute(new MyThread6());
        //适用于Callable
//        service.submit();
        service.shutdown();

    }
}

class MyThread6 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
