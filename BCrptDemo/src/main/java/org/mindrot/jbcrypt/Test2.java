package org.mindrot.jbcrypt;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/23 22:04
 * @Package: org.mindrot.jbcrypt
 * @CurrentProject: BCrptDemo
 * @version: 1.0
 */
public class Test2 {
  public static void main(String[] args) {
    //密码对比
    boolean checkpw = BCrypt.checkpw("123456",
            "$2a$10$e68Lq.1CZt7LuSJj9PH3gO9S8z14ULGJe1n/HkUvZD1TWLehlE/Ea");
    System.out.println(checkpw);
  }


}
