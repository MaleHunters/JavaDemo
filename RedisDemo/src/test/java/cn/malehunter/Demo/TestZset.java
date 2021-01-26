package cn.malehunter.Demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
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
public class TestZset {

  @Autowired
  private RedisTemplate redisTemplate;


  // 存值 默认：由低到高的排序
  @Test
  public void testZsetValue(){
    redisTemplate.boundZSetOps("zsetName").add("吕布",1);
    redisTemplate.boundZSetOps("zsetName").add("典韦",3);
    redisTemplate.boundZSetOps("zsetName").add("赵云",2);
    redisTemplate.boundZSetOps("zsetName").add("关羽",4);
    redisTemplate.boundZSetOps("zsetName").add("张飞",6);
    redisTemplate.boundZSetOps("zsetName").add("马超",5);
  }

  // 降序排序查询值
  @Test
  public void testSort(){
    Set sortName = redisTemplate.boundZSetOps("zsetName").reverseRange(0, 10);
    System.out.println(sortName);
  }

  // 升序排序查询之
  @Test
  public void testFindZsetValue(){
    Set zsetName = redisTemplate.boundZSetOps("zsetName").range(0, 10);
    System.out.println(zsetName);
  }

  // 增加分数值
  @Test
  public void addScore(){
    redisTemplate.boundZSetOps("zsetName").incrementScore("吕布",20);
  }

  // 查询分数与值
  @Test
  public void findValueAndScore(){
    Set<ZSetOperations.TypedTuple> nameAndvalue = redisTemplate.boundZSetOps("zsetName").reverseRangeWithScores(0, 10);
    for (ZSetOperations.TypedTuple typedTuple : nameAndvalue) {
      System.out.println("姓名 " + typedTuple.getValue());
      System.out.println("分数 " + typedTuple.getScore());
    }
  }








}
