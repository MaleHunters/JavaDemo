package cn.malehunter.Demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TestList {

  @Autowired
  private RedisTemplate redisTemplate;

  /**
   * 右压栈 ：后添加的对象排在后面
   */
  @Test
  public void testListValueRight(){
    redisTemplate.boundListOps("nameList1").rightPush("刘备");
    redisTemplate.boundListOps("nameList1").rightPush("关羽");
    redisTemplate.boundListOps("nameList1").rightPush("张飞");
  }
  /**
   * 左压栈：后添加的对象排在前面
   */
  @Test
  public void testListValueLeft(){
    redisTemplate.boundListOps("nameList2").leftPush("刘备");
    redisTemplate.boundListOps("nameList2").leftPush("关羽");
    redisTemplate.boundListOps("nameList2").leftPush("张飞");
  }

  // 右压栈查询
  @Test
  public void testListGetValueRight(){
    // range(开始索引，查询个数) 查询个数为-1的话，不限制查询个数
    List nameList1 = redisTemplate.boundListOps("nameList1").range(0, -1);//从第0个查到1
    System.out.println(nameList1);
  }

  // 左压栈查询
  @Test
  public void testListGetValueLeft(){
    List nameList2 = redisTemplate.boundListOps("nameList2").range(0, -1);
    System.out.println(nameList2);
  }

  // 根据索引查询,查询某个位置的元素
  @Test
  public void testSearchByIndex(){
    String nameList2 =(String)redisTemplate.boundListOps("nameList2").index(1);
    System.out.println(nameList2);
  }

  // 移除某个元素
  // remove(移除几个元素，移除元素的值)
  @Test
  public void testDelete(){
    redisTemplate.boundListOps("nameList2").remove(1,"张飞");
  }








}
