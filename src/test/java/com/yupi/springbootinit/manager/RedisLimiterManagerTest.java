package com.yupi.springbootinit.manager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 季 雷
 * @version 1.0
 * @Date 2023/07/25/0:20
 */
@SpringBootTest
class RedisLimiterManagerTest {

    @Resource
    private RedisLimiterManager redisLimiterManager;

    @Test
    void doRateLimit() throws InterruptedException {
        String userId = "1";
        for (int i = 0; i < 2; i++) {

            redisLimiterManager.doRateLimit(userId);
            System.out.println("=============================成功======");
        }
        Thread.sleep(1000);
        for (int i = 0; i < 5; i++) {

            redisLimiterManager.doRateLimit(userId);
            System.out.println("=============================成功======");
        }
    }
}