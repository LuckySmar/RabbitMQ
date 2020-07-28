package com.rabbit.springbootrabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName RabbitMQApplication
 * @Author ZhangY
 * @Date 2020/02/20 22:52
 * @Version 1.0.0
 * @Description 启动类
 * 启动RabbitMQ，打开命令行进入到sbin目录下输入rabbitmq-server.bat install启动RabbitMQ
 */
@SpringBootApplication
public class RabbitMQApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMQApplication.class, args);
    }
}
