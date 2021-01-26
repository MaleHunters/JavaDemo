package com.aliyun.demo;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/15 15:51
 * @Package: com.itheima.demo
 * @CurrentProject: aliyunossDemo
 * @version: 1.0
 */
public class Test {
  public static void main(String[] args) throws FileNotFoundException {
    // Endpoint以杭州为例，其它Region请按实际情况填写。
    String endpoint = "http://oss-cn-qingdao.aliyuncs.com";
// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
    String accessKeyId = "LTAI4G7ZE6Czrsaa15cK9sZy";
    String accessKeySecret = "hGa3pFRwhd4prRi1wzD33nXQ53IYXf";

// 创建OSSClient实例。
    OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

// 上传文件流。
    // 上传文件地址
    InputStream inputStream = new FileInputStream("D:\\Users\\cong\\Pictures\\Saved Pictures\\a.jpg");
    // 阿里云库的名称   上传文件的命名
    ossClient.putObject("malehunterqingcheng", "test.jpg", inputStream);

// 关闭OSSClient。
    ossClient.shutdown();
  }
}
