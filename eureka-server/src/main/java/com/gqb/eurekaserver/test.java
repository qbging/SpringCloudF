package com.gqb.eurekaserver;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class test {

    List<String> list = new ArrayList<>();
    public void add(String s){
        list.add(s);
    }
    public int get(){
        return list.size();
    }

    public static void main(String[] args) {
        test t = new test();
        CountDownLatch latch = new CountDownLatch(1);
        Thread t1 = new Thread(() -> {
            for (int i =0;i<10;i++){
                System.out.println("list + " +i);
                t.add(i+"");
                if (i == 4){
                    latch.countDown();//门闩减一
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1") ;
        t1.start();
        Thread t2 = new Thread(()->{
            if (t.get() != 5){
                try {
                    latch.await();//等待门闩的开放，不是进入等待队列
                    System.out.println("t2唤醒");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("list :"+t.get());
        },"t2");
        t2.start();
    }
}
