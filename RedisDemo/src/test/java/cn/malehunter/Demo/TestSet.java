package cn.malehunter.Demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/26 20:54
 * @Package: cn.malehunter.Demo
 * @CurrentProject: RedisDemo
 * @version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-redis.xml")
public class TestSet {

  @Autowired
  private RedisTemplate redisTemplate;


  // 存值
  @Test
  public void setValue(){
    redisTemplate.boundSetOps("nameSet").add("曹操");
    redisTemplate.boundSetOps("nameSet").add("刘备");
    redisTemplate.boundSetOps("nameSet").add("孙权");
  }

  // 取值
  @Test
  public void getValue(){
    Set nameSet = redisTemplate.boundSetOps("nameSet").members();
    System.out.println(nameSet);
  }
  // 删除其中一个值
  @Test
  public void deleteValue(){
    redisTemplate.boundSetOps("nameSet").remove("孙权");
  }
  // 删除全部值
  @Test
  public void deleteAllValue(){
    redisTemplate.delete("nameSet");
  }








}
