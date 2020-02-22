package com.qiming.pom.rabbitmq.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.util.HashMap;
import java.util.Map;

public class ChannelUtils {

  public static Channel getChannelInstance(String connectionDescription) {
    try {
      ConnectionFactory connectionFactory = getConnectionFactory();
      Connection connection = connectionFactory.newConnection(connectionDescription);
      return connection.createChannel();
    } catch (Exception e) {
      throw new RuntimeException("获取Channel连接失败");
    }
  }

  private static ConnectionFactory getConnectionFactory() {
    ConnectionFactory connectionFactory = new ConnectionFactory();

    // 配置连接信息
    connectionFactory.setHost("10.144.91.121");
    //注意端口号不是web端口号
    connectionFactory.setPort(30133);
    connectionFactory.setVirtualHost("epic-rabbitmq");
    connectionFactory.setUsername("epic");
    connectionFactory.setPassword("epic1234");

    // 网络异常自动连接恢复
    connectionFactory.setAutomaticRecoveryEnabled(true);
    // 每10秒尝试重试连接一次
    connectionFactory.setNetworkRecoveryInterval(10000);

    // 设置ConnectionFactory属性信息
    Map<String, Object> connectionFactoryPropertiesMap = new HashMap();
    connectionFactoryPropertiesMap.put("principal", "Qiming");
    connectionFactoryPropertiesMap.put("description", "RabbitMQ测试系统");
    connectionFactoryPropertiesMap.put("emailAddress", "yzzqm@hotmail.com");
    connectionFactory.setClientProperties(connectionFactoryPropertiesMap);

    return connectionFactory;
  }

}
