package com.yxp.one.sync007;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yangxiooping on 2018/2/7.
 */
public class VolatileNoAtomic extends Thread{
    //private static volatile int count;
    private static AtomicInteger count = new AtomicInteger(0);
    private static void addCount(){
        for (int i = 0; i < 10000; i++) {
            //count++ ;
             count.incrementAndGet();
        }
        System.out.println(count);
    }
    public void run(){
        addCount();
    }
    public static void main(String[] args) {
        VolatileNoAtomic[] arr = new VolatileNoAtomic[100];
        for (int i = 0; i < 10; i++) {
            arr[i] = new VolatileNoAtomic();
        }
        for (int i = 0; i < 10; i++) {
            arr[i].start();
        }
    }
}