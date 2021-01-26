package cn.malehunter.Demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/26 20:54
 * @Package: cn.malehunter.Demo
 * @CurrentProject: RedisDemo
 * @version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-redis.xml")
public class TestValue {

  @Autowired
  private RedisTemplate redisTemplate;


  // 存值
  @Test
  public void setValue(){
    redisTemplate.boundValueOps("name").set("MaleHunter");
    // 设置存活时间 expire(数值，数值代表的时间单位)
    redisTemplate.boundValueOps("name").expire(10,TimeUnit.SECONDS);
  }

  // 取值
  @Test
  public void getValue(){
    String str =(String)redisTemplate.boundValueOps("name").get();
    System.out.println(str);
  }
  // 删除值
  @Test
  public void deleteValue(){
    redisTemplate.delete("name");
  }

}
