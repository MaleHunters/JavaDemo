package com.malehunter.Demo;

import com.sun.xml.internal.ws.util.xml.ContentHandlerToXMLStreamWriter;
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
// 消息生产者
public class Test1 {
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-rabbitmq-producer.xml");
    RabbitTemplate rabbitTemplate =(RabbitTemplate)context.getBean("rabbitTemplate");
    rabbitTemplate.convertAndSend("","queue.test","直接模式测试");
    ((ClassPathXmlApplicationContext) context).close();
  }

}
