package com.malehunter.Demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/30 18:28
 * @Package: com.malehunter.Demo
 * @CurrentProject: rabbitmqDemo
 * @version: 1.0
 */
// 消息消费者
public class Test2 {
  public static void main(String[] args) {

    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-rabbitmq-consumer.xml");

  }
}
