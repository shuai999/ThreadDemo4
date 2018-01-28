package com.thread.demo4;

import android.util.Log;

/**
 * @author : Created by ces
 * @date: on 2018/1/28.
 * @function: 指定给某个对象加锁
 */
public class Account {
    String name ;
    float amount ;

    public Account(String name , float amount){
        this.name = name ;
        this.amount = amount ;
    }

    //存钱
    public void deposit(float amt){
        amount +=amt;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    //取钱
    public void withDraw(float amt){
        amount -=amt ;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public float getBalance(){
        return  amount ;
    }

}
