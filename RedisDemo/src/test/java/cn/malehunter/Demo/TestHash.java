package cn.malehunter.Demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveSetOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
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
public class TestHash {

  @Autowired
  private RedisTemplate redisTemplate;

  // 存值
  @Test
  public void testSetHashValue(){
    redisTemplate.boundHashOps("nameHash").put("a","唐僧");
    redisTemplate.boundHashOps("nameHash").put("b","孙悟空");
    redisTemplate.boundHashOps("nameHash").put("c","猪八戒");
    redisTemplate.boundHashOps("nameHash").put("d","沙和尚");
  }

  // 查询所有的key
  @Test
  public void testFindAllHashKeys(){
    Set keys = redisTemplate.boundHashOps("nameHash").keys();
    System.out.println(keys);
  }

  // 查询所有的值
  @Test
  public void testFindAllHashValues(){
    List values = redisTemplate.boundHashOps("nameHash").values();
    System.out.println(values);
  }

  // 根据小key去查值
  @Test
  public void testFindHashValueByKey(){
    String b = (String)redisTemplate.boundHashOps("nameHash").get("b");
    System.out.println(b);
  }

  // 删除某个小key的值
  @Test
  public void deleteHashValueBykey(){
    redisTemplate.boundHashOps("nameHash").delete("d");
  }

  // 删除大key（所有的值）
  @Test
  public void delteAllHashValue(){
    redisTemplate.delete("nameHash");
  }

}
