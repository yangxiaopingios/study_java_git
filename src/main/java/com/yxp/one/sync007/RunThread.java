package com.yxp.one.sync007;

/**
 * Created by yangxiooping on 2018/2/7.
 */
public class RunThread extends Thread{

    private volatile boolean isRunning = true;
    private void setRunning(boolean isRunning){
        this.isRunning = isRunning;
    }
    public void run(){
        System.out.println("进入run方法..");
        int i = 0;
        while(isRunning == true){
            try {
                Thread.sleep(10);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("循环中...");
        }
        System.out.println("线程停止");
    }
    public static void main(String[] args) throws InterruptedException {
        RunThread rt = new RunThread();
        rt.start();
        Thread.sleep(50);
        rt.setRunning(false);
        System.out.println("isRunning的值已经被设置了false");
    }
}