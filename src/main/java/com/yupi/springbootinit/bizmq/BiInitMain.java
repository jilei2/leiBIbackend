package com.yupi.springbootinit.bizmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author 季 雷
 * @version 1.0
 * @Date 2023/07/27/21:01
 */
public class BiInitMain {
    public static void main(String[] args) {
        try {
            //创建连接工厂
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            //创建连接
            Connection connection = factory.newConnection();
            //创建通道
            Channel channel = connection.createChannel();
            //定义交换机的名称为"code_exchange"
            String EXCHANGE_NAME = BiMqConstant.BI_EXCHANGE_NAME;
            //声明交换机,指定交换机类型为direct
            channel.exchangeDeclare(EXCHANGE_NAME, "direct");
            //创建队列,随机分配一个队列名称
            String queueName = BiMqConstant.BI_QUEUE_NAME;
            //生命队列，设置队列持久化，非独占，非自动删除,并传入额外的参数为null
            channel.queueDeclare(queueName, true, false, false, null);
            //将队列绑定到交换机，指定路由键为"my_routingKey"
            channel.queueBind(queueName, EXCHANGE_NAME, BiMqConstant.BI_ROUTING_KEY);
        }  catch (Exception e) {

        }
    }
}
