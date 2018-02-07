package com.yxp.one.sync007;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by yangxiooping on 2018/2/7.
 */
public class AtomicUse {

    private static AtomicInteger count = new AtomicInteger(0);
    //多个addAndGet在一个方法内是非原子性的，需要加synchronized进行修饰，保证4个addAndGet整体原子性
    public synchronized int multiAdd(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count.addAndGet(1);
        count.addAndGet(1);//+2
        return count.get();
    }
    public static void main(String[] args) {
        final AtomicUse au = new AtomicUse();

        List<Thread> ts = new ArrayList<Thread>();
        for (int i = 0; i < 5; i++) {
            ts.add(new Thread(new Runnable() {
                public void run() {
                    System.out.println(au.multiAdd());
                }
            }));
        }
        for(Thread t : ts){
            t.start();
        }
    }
}