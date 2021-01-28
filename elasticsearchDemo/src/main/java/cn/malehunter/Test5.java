package cn.malehunter;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

/**
 * @Auther: MaleHunter
 * @Date: 2021/1/28 21:43
 * @Package: cn.malehunter
 * @CurrentProject: elasticsearchDemo
 * @version: 1.0
 * 过滤查询 不需要计算 score
 */
public class Test5 {
  public static void main(String[] args) throws IOException {
    // 连接rest接口
    HttpHost httpHost = new HttpHost("127.0.0.1",9200,"http");
    RestClientBuilder builder = RestClient.builder(httpHost);
    RestHighLevelClient restHighLevelClient = new RestHighLevelClient(builder);

    // 封装查询请求
    SearchRequest searchRequest = new SearchRequest("sku"); //设置查询索引
    searchRequest.types("doc"); // 设置查询类型
    SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    // 布尔查询
    BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery(); //布尔查询构建器
    // 词条查询
    TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("brandName", "小米");
    boolQueryBuilder.filter(termQueryBuilder);

    searchSourceBuilder.query(boolQueryBuilder);


    searchRequest.source(searchSourceBuilder);


    // 获取查询结果
    SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
    SearchHits searchHits = searchResponse.getHits();
    long totalHits = searchHits.getTotalHits();
    System.out.println("记录数" + totalHits);
    SearchHit[] hits = searchHits.getHits();
    for (SearchHit hit : hits) {
      String sourceAsString = hit.getSourceAsString();
      System.out.println(sourceAsString);
    }
    restHighLevelClient.close();
  }
}
