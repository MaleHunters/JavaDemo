package com.malehunter.Demo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/30 18:11
 * @Package: com.malehunter.Demo
 * @CurrentProject: rabbitmqDemo
 * @version: 1.0
 */
// (分列模式)消息生产者
public class Test1_2 {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-rabbitmq-producer.xml");
    RabbitTemplate rabbitTemplate =(RabbitTemplate)context.getBean("rabbitTemplate");
    rabbitTemplate.convertAndSend("exchange.fanout_test","","分列模式测试");
    ((ClassPathXmlApplicationContext) context).close();
  }

}
