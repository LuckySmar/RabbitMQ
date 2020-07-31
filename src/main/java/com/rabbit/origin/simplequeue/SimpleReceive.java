package com.rabbit.origin.simplequeue;

import com.rabbit.origin.utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

/**
 * @ClassName SimpleReceive
 * @Author ZhangY
 * @Date 2020/02/21 12:42
 * @Version 1.0.0
 * @Description 简单队列实现接收消息
 * 生产者将消息发送到队列，消费者从队列中获取消息。
 */
public class SimpleReceive {
    public static void main(String[] args) throws Exception {

        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(SimpleSend.QUEUE_NAME, /*队列名称*/false,/*是否持久化*/ false,/*是否为独占队列*/ false,/*是否自动删除*/ null/*队列的其他参数*/);

        // 定义队列的消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);

        // 监听队列
        channel.basicConsume(SimpleSend.QUEUE_NAME, true, consumer);

        // 获取消息
        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [x] Received '" + message + "'");
        }

    }

}
