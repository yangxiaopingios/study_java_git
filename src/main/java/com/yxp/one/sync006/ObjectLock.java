package com.yxp.one.sync006;

/**
 * Created by yangxiooping on 2018/2/7.
 */
public class ObjectLock {

    public void method1(){
        synchronized (this) {	//对象锁
            try {
                System.out.println("do method1..start");
                Thread.sleep(2000);
                System.out.println("do method1..end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void method2(){		//类锁
        synchronized (ObjectLock.class) {
            try {
                System.out.println("do method2..start");
                Thread.sleep(2000);
                System.out.println("do method2..end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private Object lock = new Object();
    public void method3(){		//任何对象锁
        synchronized (lock) {
            try {
                System.out.println("do method3..start");
                Thread.sleep(2000);
                System.out.println("do method3..end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        final ObjectLock objLock = new ObjectLock();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                objLock.method1();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                objLock.method2();
            }
        });
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                objLock.method3();
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
