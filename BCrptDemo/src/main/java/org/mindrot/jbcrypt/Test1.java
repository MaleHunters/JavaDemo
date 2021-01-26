package org.mindrot.jbcrypt;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/23 21:59
 * @Package: org.mindrot.jbcrypt
 * @CurrentProject: BCrptDemo
 * @version: 1.0
 */
public class Test1 {
  public static void main(String[] args) {
    String gensalt = BCrypt.gensalt(); //创建盐，随机的字符串
    System.out.println(gensalt);
    String hashpw = BCrypt.hashpw("123456", gensalt); //加密
    System.out.println(hashpw);
    System.out.println("hello,world");
  }
}
