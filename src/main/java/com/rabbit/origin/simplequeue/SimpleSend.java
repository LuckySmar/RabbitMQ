package com.rabbit.origin.simplequeue;

import com.rabbit.origin.utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.util.UUID;

/**
 * @ClassName Send
 * @Author ZhangY
 * @Date 2020/02/21 12:26
 * @Version 1.0.0
 * @Description 简单队列实现发送消息
 */
public class SimpleSend {
    static boolean flag = true;
    protected static final  String QUEUE_NAME = "queue01";
    public static void main(String[] args) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        // 从连接中创建通道
        Channel channel = connection.createChannel();

        // 声明（创建）队列   参数说明
        //  * @param queue the name of the queue
        //  * @param durable true if we are declaring a durable queue (the queue will survive a server restart)
        //  * @param exclusive true if we are declaring an exclusive queue (restricted to this connection)
        //  * @param autoDelete true if we are declaring an autodelete queue (server will delete it when no longer in use)
        //  * @param arguments other properties (construction arguments) for the queue
        //  * @return a declaration-confirm method to indicate the queue was successfully declared
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 消息内容
        while (flag) {
            String message = "Hello World!"+ UUID.randomUUID().toString();
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
            Thread.sleep(1000);
        }
        //关闭通道和连接
        channel.close();
        connection.close();

    }
}
