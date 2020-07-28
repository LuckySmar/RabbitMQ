package com.rabbit.springbootrabbitmq.simplequeue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName: SimpleQueueReceive
 * @Author: ZhangYue26
 * @Description: 简单队列接受者
 * @Date: 2020-07-28
 */
@Component
public class SimpleQueueReceive {
    // 通过注解自动创建 spring.simple.queue 队列

    @RabbitListener(queues = SimpleQueueSender.QUEUE_NAME)
    public void listen(String msg) {
        System.out.println("简单队列 接收到消息：" + msg);
    }

}
