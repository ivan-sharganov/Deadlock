public class MyThread extends  Thread{
    Object lock1 = new Object();
    Object lock2 = new Object();


    void method1() {
        synchronized (lock1) {
            synchronized (lock2) {
                System.out.println("1");
            }
        }
    }

    void method2() {
        synchronized (lock2) {
            synchronized (lock1) {
                System.out.println("2");
            }
        }
    }
}