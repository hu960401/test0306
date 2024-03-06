package com.huyl.example.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName RedisIdWorker
 * @Description:
 * @Author: 12072    huyl
 * @CreateDate: 2024/3/6 19:46
 * @Version: 1.0
 */
@Slf4j
@Component
public class RedisIdWorker {

    private StringRedisTemplate stringRedisTemplate;

    public RedisIdWorker(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    //开始时间戳
    private static final long BEGIN_TIMESTAMP = 1640995200L;//2022.01.01 00:00:00

    //序列号位数
    private static final int COUNT_BITS = 32;

    public long nextId(String keyPrefix){
        //生成时间戳
        LocalDateTime now = LocalDateTime.now();
        long nowSecond = now.toEpochSecond(ZoneOffset.UTC);
        long timeStamp = nowSecond-BEGIN_TIMESTAMP;

        //2.生成序列号
        //2.1.获取当前时间，精确到天  每天一个key,方便统计每天的大小
        String date = now.format(DateTimeFormatter.ofPattern("yyyy:MM:dd"));
        //2.2 利用redis的自增长
        Long count = stringRedisTemplate.opsForValue().increment("icr:" + keyPrefix + ":" + date);

        System.out.println("here");


        //拼接并返回
        return timeStamp << COUNT_BITS | count;
    }
}
