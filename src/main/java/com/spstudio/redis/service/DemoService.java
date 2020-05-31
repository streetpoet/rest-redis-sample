package com.spstudio.redis.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spstudio.redis.component.RedisUtil;

@Service
public class DemoService {

    @Autowired
    RedisUtil redis;

    @PostConstruct
    public void init() throws InterruptedException {
        redis.hset("family", "husband", "w", 1L);
        redis.hset("family", "wife", "y", -1L);
        System.out.println(redis.hmget("family").get("husband"));
        System.out.println(redis.hmget("family").get("wife"));
    }
}
