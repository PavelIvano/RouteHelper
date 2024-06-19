package com.example.pavel2.Thread;

public class Client extends Thread {
    static class Account {
        int money = 0;
    }

    Account account;

    public Client(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        synchronized (this.account) {
            if (this.account.money - 70 > 0) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                this.account.money -= 70;
            } else {
                System.out.println("No money");
            }
            System.out.println("End");
        }
    }



    public static void main(String[] args) {
        Account a = new Account();
        a.money = 100;
        new Client(a).start();
        new Client(a).start();

        try {
            Thread.sleep(600);
        } catch(InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(a.money);
    }
}
