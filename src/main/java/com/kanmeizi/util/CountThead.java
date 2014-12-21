package com.kanmeizi.util;

import java.util.Calendar;

/**
 * Created by liuzhengyang on 2014/12/20.
 */
public class CountThead implements Runnable {
    private static boolean state = true;
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread());
        }
    }

    public static void main(String[] args) {
        new Thread(new CountThead()).start();
    }
}
