package com.pat.thread;

import org.checkerframework.checker.units.qual.C;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/10/19
 * @Modify
 * @ce
 */
public class CallerTaskDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Hello World!";
    }

    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new CallerTaskDemo());
        new Thread(futureTask).start();

        try {
            String s = futureTask.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
