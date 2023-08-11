package com.yupi.springbootinit.manager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 季 雷
 * @version 1.0
 * @Date 2023/07/23/20:15
 */
@SpringBootTest
class AiManagerTest {

    @Resource
    private AiManager aiManager;

    @Test
    void doChat() {
        String anwer = aiManager.doChat(1659171950288818178L, "分析需求：\n" +
                "分析网站用户的增长情况\n" +
                "原始数据：\n" +
                "1号,10\n" +
                "2号,20\n" +
                "3号,30\n");
        System.out.println(anwer);
    }
}