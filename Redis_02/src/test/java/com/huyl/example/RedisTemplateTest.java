package com.huyl.example;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @ClassName RedisTemplateTest
 * @Description:
 * @Author: 12072    huyl
 * @CreateDate: 2024/3/5 14:50
 * @Version: 1.0
 */
@SpringBootTest
public class RedisTemplateTest {

//    @Autowired
//    private RedisTemplate redisTemplate;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;



    @Test
    void test(){

//        System.out.println("here");

        redisTemplate.opsForHash().put("user:121212","name","胡银玲_hahahahaha");
        System.out.println( redisTemplate.opsForHash().get("user:121212", "name"));
//        try {
//            redisTemplate.opsForValue().set("name:1","胡银玲");
//            System.out.println(redisTemplate.opsForValue().get("name:1"));
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }

//        redisUtil.set("name:1","胡银玲");



    }
}
