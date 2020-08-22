package com.lnzz.exer;

/**
 * ClassName：ThreadTest8
 *
 * @Author 冷暖自知
 * @Date 2020/8/22 16:17
 * @Version 1.0
 * @Description 使用同步机制将单例模式中的懒汉式改写为线程安全的
 */
public class ThreadTest8 {
}

class Bank {
    private Bank() {
    }

    private static Bank instance = null;

    private static Bank getInstance() {
        //方式一：效率稍差
     /*   synchronized (Bank.class) {
            if (instance == null) {
                instance = new Bank();
            }
            return instance;
        }*/

        //方式二：效率更高
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
