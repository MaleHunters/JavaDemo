package cn.malehunter;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/28 20:52
 * @Package: cn.malehunter
 * @CurrentProject: elasticsearchDemo
 * @version: 1.0
 * 批处理添加
 */
public class Test2 {
  public static void main(String[] args) throws IOException {
    // 1.连接rest接口
    HttpHost httpHost = new HttpHost("127.0.0.1",9200,"http");
    RestClientBuilder builder = RestClient.builder(httpHost);
    RestHighLevelClient restHighLevelClient = new RestHighLevelClient(builder);
    // 2.封装请求对象(索引名称，文档类型名称，id)
    BulkRequest bulkRequest = new BulkRequest();


    IndexRequest indexRequest = new IndexRequest("sku","doc","5");
    Map skuMap = new HashMap();
    skuMap.put("name","华为Mate20 pro");
    skuMap.put("brandName","华为");
    skuMap.put("categoryName","手机");
    skuMap.put("price",101021);
    skuMap.put("createTime","2019-05-01");
    skuMap.put("saleNum",101021);
    skuMap.put("commentNum",10102321);
    Map spec = new HashMap();
    spec.put("网络制式","移动4G");
    spec.put("屏幕尺寸",5);
    skuMap.put("spec",spec);
    indexRequest.source(skuMap);

    // 批量导入
    bulkRequest.add(indexRequest);




    // 3.获取执行结果
    // IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
    // int status = indexResponse.status().getStatus();
    BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
    int status = bulkResponse.status().getStatus();
    System.out.println(status);

    // 关闭
    restHighLevelClient.close();


  }
}
