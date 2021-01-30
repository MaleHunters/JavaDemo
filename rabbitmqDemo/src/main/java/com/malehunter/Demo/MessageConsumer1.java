package com.malehunter.Demo;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/30 18:22
 * @Package: com.malehunter.Demo
 * @CurrentProject: rabbitmqDemo
 * @version: 1.0
 */
// 消息监听类
public class MessageConsumer1 implements MessageListener {
  @Override
  public void onMessage(Message message) {
    System.out.println("MessageConsumer1");
    byte[] body = message.getBody();
    String s = new String(body);
    System.out.println(s);

  }
}
