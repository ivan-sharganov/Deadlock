package Deadlock;

public class Main {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        new Thread(()->{
            synchronized (lock1) {
                try {Thread.sleep(1000);} catch (Throwable ignored){}
                synchronized (lock2) {
                    System.out.println("1");
                }
            }
        }).start();

        new Thread(()->{
            synchronized (lock2) {
                try {Thread.sleep(1000);} catch (Throwable ignored){}
                synchronized (lock1) {
                    System.out.println("2");
                }
            }
        }).start();
    }
}
