package com.pat.thread.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/11/22
 * @Modify
 * @since
 */
public class SimpleDateFormatterDemo {

    public static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        for (int i = 0; i< 10; i++) {
            int j = i;
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    String date = new SimpleDateFormatterDemo().date(j);
                    System.out.println(date);
                }
            });
        }
        executorService.shutdown();
    }

    public String date(int seconds) {
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = SafeDateFormatter.dateFormatThreadLocal.get();
        return dateFormat.format(date);
    }

    static class SafeDateFormatter {
        public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>() {
            @Override
            protected SimpleDateFormat initialValue() {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            }
        };
    }
}
