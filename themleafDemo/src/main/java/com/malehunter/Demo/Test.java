package com.malehunter.Demo;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/25 13:00
 * @Package: com.malehunter.Demo
 * @CurrentProject:themleafDemo
 * @version: 1.0
 */
public class Test {
  public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
    // 1.上下文（数据模型）
    Context context = new Context();
    Map map = new HashMap<>();
    map.put("name", "丛培通");
    context.setVariables(map);
    // 2.准备文件
    File file = new File("e:/test_out.html");
    PrintWriter printWriter = new PrintWriter(file, "utf-8");
    // 3.生成文件和页面
    ClassLoaderTemplateResolver classLoaderTemplateResolver = new ClassLoaderTemplateResolver(); // 模板解析器
    classLoaderTemplateResolver.setTemplateMode(TemplateMode.HTML); //模板模型
    classLoaderTemplateResolver.setSuffix(".html"); //后缀
    TemplateEngine templateEngine = new TemplateEngine(); //创建模板引擎

    templateEngine.setTemplateResolver(classLoaderTemplateResolver); //设置模板解析器
    templateEngine.process("test",context,printWriter); // 执行模板引擎
  }
  }
