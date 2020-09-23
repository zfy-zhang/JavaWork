package com.pat.design.di;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/9/23
 * @Modify
 * @since
 */
public class RedisCounter {
    private String ipAddress;
    private String port;
    public RedisCounter(String ipAddress, String port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }

    public int incrementAndGet() {
        System.out.println("Connect to " + this.ipAddress + ":" + this.port);
        return 10;
    }
}
