package com.thread.demo4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
/**
 * @author : Created by ces
 * @date: on 2018/1/28.
 * @function: 指定给某个对象加锁
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Account account = new Account("zhangsan" , 10000.0f) ;
        AccountOperator operator = new AccountOperator(account) ;

        final int THREAD_NUM = 5 ;
        Thread threads[] = new Thread[THREAD_NUM] ;
        for (int i = 0; i < THREAD_NUM; i++) {
            threads[i] = new Thread(operator , "Thread" + i);
            threads[i].start();
        }

    }



    public class AccountOperator implements Runnable{

        private Account account ;
        public AccountOperator(Account account){
            this.account = account ;
        }

        @Override
        public void run() {
            synchronized (account){
                //存钱500
                account.deposit(500);
                //取钱500
                account.withDraw(500);
                Log.e("cesAccount--->", Thread.currentThread().getName() + ":" + account.getBalance()) ;
                //运行结果如下
//                Thread0:10000.0
//                Thread1:10000.0
//                Thread2:10000.0
//                Thread3:10000.0
//                Thread4:10000.0
            }
        }
    }
}
