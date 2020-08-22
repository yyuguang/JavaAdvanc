package com.lnzz.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * ClassName：Thread5
 *
 * @Author 冷暖自知
 * @Date 2020/8/22 22:21
 * @Version 1.0
 * @Description 创建多线程的方式三：实现Callable接口 ---JDK5.0新增
 */
public class Thread5 {
    public static void main(String[] args) {
        MyThread5 t1 = new MyThread5();
        FutureTask futureTask = new FutureTask(t1);

        new Thread(futureTask).start();
        try {
            Object num = futureTask.get();
            System.out.println(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class MyThread5 implements Callable {
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}
