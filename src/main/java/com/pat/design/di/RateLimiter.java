package com.pat.design.di;

/**
 * @Description:
 * @Author <a href="mailto:zfy_zang@163.com">Vincent</a>
 * @Create 2020/9/23
 * @Modify
 * @since
 */
public class RateLimiter {
    private RedisCounter redisCounter;
    public RateLimiter(RedisCounter redisCounter) {
        this.redisCounter = redisCounter;
    }
    public boolean isValid() {
        this.redisCounter.incrementAndGet();
        return true;
    }
}
