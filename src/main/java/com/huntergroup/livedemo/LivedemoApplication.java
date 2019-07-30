package com.huntergroup.livedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ChenLiang
 * @version 1.0.0
 * @description 启动类
 * @data: 2019/7/30 10:58
 */

@EnableAutoConfiguration
@SpringBootApplication
public class LivedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LivedemoApplication.class, args);
    }

}
