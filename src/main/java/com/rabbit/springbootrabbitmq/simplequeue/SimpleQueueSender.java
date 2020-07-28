package com.rabbit.springbootrabbitmq.simplequeue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: SimpleQueueSender
 * @Author: ZhangYue26
 * @Description: 简单队列发送者
 * @Date: 2020-07-28
 */
@Slf4j
@Controller
public class SimpleQueueSender {

    public final static String QUEUE_NAME = "spring.simple.queue";

    @Autowired
    private AmqpTemplate amqpTemplate;

    @ResponseBody
    @RequestMapping(value = "/send",method = RequestMethod.GET)
    public void send(){
        while (true) {
            String message = "你好" + System.currentTimeMillis();
            amqpTemplate.convertAndSend(QUEUE_NAME, "你好" + System.currentTimeMillis());
            log.info("发送消息："+message);
        }
    }

}
