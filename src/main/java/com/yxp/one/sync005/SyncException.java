package com.yxp.one.sync005;

/**
 * Created by yangxiooping on 2018/2/5.
 */
public class SyncException {

    private int i = 0;
    public synchronized void operation(){
        while(true){
            while(true){
                try {
                    i++;
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " , i = " + i);
                    if(i == 5){//模拟业务逻辑出现异常，抛出异常，在方法抛出异常的时候会自动解锁
                        throw new RuntimeException();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void operation2(){
        try {
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + " , i = " + i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        final SyncException se = new SyncException();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                se.operation();
            }
        },"t1");
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                se.operation2();
            }
        },"t2");
        t1.start();
        t2.start();
    }
}
