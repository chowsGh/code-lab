package top.clydezhou.lab.demo;

import static org.junit.Assert.assertTrue;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static void main(String[] args) throws IOException {
        //        HttpcL
        try (CloseableHttpClient aDefault = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost("http://localhost:8080/spring-mvc/web-xml-config-servlet/hello/param");
            List<NameValuePair> list = new LinkedList<>();
            BasicNameValuePair param1 = new BasicNameValuePair("paramName", "中文乱码");
            list.add(param1);
            // 使用URL实体转换工具
            UrlEncodedFormEntity entityParam = new UrlEncodedFormEntity(list, "UTF-8");
            httpPost.setEntity(entityParam);
            CloseableHttpResponse execute = aDefault.execute(httpPost);
            System.out.println("---------------" + EntityUtils.toString(execute.getEntity(), "UTF-8"));

            HttpGet httpGet = new HttpGet("http://localhost:8080/spring-mvc/web-xml-config-servlet/hello/param?paramName=" + URLEncoder.encode("中文乱码",
                StandardCharsets.UTF_8.name()));
            execute = aDefault.execute(httpPost);
            System.out.println("---------------" + EntityUtils.toString(execute.getEntity(), "UTF-8"));
        }
    }
}
