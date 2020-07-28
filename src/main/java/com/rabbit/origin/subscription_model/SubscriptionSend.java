package com.rabbit.origin.subscription_model;

import com.rabbit.origin.utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.util.UUID;

/**
 * @ClassName SubscriptionSend
 * @Author ZhangY
 * @Date 2020/02/21 13:31
 * @Version 1.0.0
 * @Description 订阅模式下的发送者
 */
public class SubscriptionSend {
    protected final static String EXCHANGE_NAME = "test-exchange";
    public final static String ROUTING_KEY = "Routing-Key-Java";

    private static boolean flag = true;
    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");   //类型一定要与管理器中的相同

        while (flag) {
            // 消息内容
            String message = "Hello World!"+ UUID.randomUUID().toString();
            channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
        channel.close();
        connection.close();
    }
}
