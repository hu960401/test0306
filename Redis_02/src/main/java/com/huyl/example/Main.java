package com.huyl.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @ClassName ${NAME}
 * @Description:
 * @Author: ${USER}	huyl
 * @CreateDate: ${DATE} ${TIME}
 * @Version: 1.0
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }


}