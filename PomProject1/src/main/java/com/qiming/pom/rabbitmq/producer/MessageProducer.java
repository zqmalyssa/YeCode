package com.qiming.pom.rabbitmq.producer;

import com.qiming.pom.rabbitmq.utils.ChannelUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

public class MessageProducer {

  public static void main(String[] args) throws IOException, TimeoutException {
    Channel channel = ChannelUtils.getChannelInstance("WOW生产者");

    // 声明交换机 (交换机名, 交换机类型, 是否持久化, 是否自动删除, 是否是内部交换机, 交换机属性);
    channel.exchangeDeclare("wow.order", BuiltinExchangeType.DIRECT, true, false, false, new HashMap<>());

    // 设置消息属性 发布消息 (交换机名, Routing key, 可靠消息相关属性 后续会介绍, 消息属性, 消息体);
    AMQP.BasicProperties basicProperties = new AMQP.BasicProperties().builder().deliveryMode(2).contentType("UTF-8").build();
    channel.basicPublish("wow.order", "add", false, basicProperties, "副本信息".getBytes());
  }

}
