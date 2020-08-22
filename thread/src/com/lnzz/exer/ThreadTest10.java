package com.lnzz.exer;

/**
 * ClassName：ThreadTest10
 *
 * @Author 冷暖自知
 * @Date 2020/8/22 17:21
 * @Version 1.0
 * @Description 银行有一个账户，有两个储户分别想同一个账户存3000元，每次存1000元，存3次，每次村玩打印账户余额
 */
public class ThreadTest10 {
    public static void main(String[] args) {
        Account account = new Account(0);
        Customer c1 = new Customer(account);
        Customer c2 = new Customer(account);

        c1.setName("小明");
        c2.setName("小红");

        c1.start();
        c2.start();
    }
}


class Customer extends Thread {

    private Account account;

    public Customer(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(1000);
        }
    }
}

class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amt) {
        if (amt > 0) {

            balance += amt;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "存钱成功，余额为：" + balance);
        }
    }
}

