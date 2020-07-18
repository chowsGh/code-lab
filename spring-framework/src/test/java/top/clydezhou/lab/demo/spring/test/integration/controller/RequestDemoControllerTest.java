package top.clydezhou.lab.demo.spring.test.integration.controller;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import top.clydezhou.lab.demo.spring.entity.UserInfo;
import top.clydezhou.lab.demo.spring.utils.JsonUtils;
import static top.clydezhou.lab.demo.spring.test.tool.RequsetTestTool.getUrl;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

/**
 * @author clyde
 * @date 2020-07-13 22:29
 */
public class RequestDemoControllerTest {

    // @Test
    public void testParam() throws IOException {
        String paramUrl = getUrl("/request-demo/param");
        try (CloseableHttpClient aDefault = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(paramUrl);
            List<NameValuePair> list = new LinkedList<>();
            BasicNameValuePair param1 = new BasicNameValuePair("paramName", "post中文乱码");
            list.add(param1);
            // 使用URL实体转换工具
            UrlEncodedFormEntity entityParam = new UrlEncodedFormEntity(list, "UTF-8");
            httpPost.setEntity(entityParam);
            try (CloseableHttpResponse execute = aDefault.execute(httpPost);) {
                System.out.println("---------------" + EntityUtils.toString(execute.getEntity(), "UTF-8"));
            }

            HttpGet httpGet = new HttpGet(paramUrl + "?paramName=" + URLEncoder
                .encode("get 中文乱码", StandardCharsets.UTF_8.name()));
            try (CloseableHttpResponse execute = aDefault.execute(httpGet);) {
                System.out.println("---------------" + EntityUtils.toString(execute.getEntity(), "UTF-8"));
            }
        }
    }

    // @Test
    public void testRequestBody() throws IOException {
        try (CloseableHttpClient aDefault = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(getUrl("/request-demo/requestBody"));
            UserInfo u = new UserInfo();
            u.setId(1L);
            StringEntity stringEntity = new StringEntity(JsonUtils.toJson(u));
            stringEntity.setContentType(ContentType.APPLICATION_JSON.withCharset(StandardCharsets.UTF_8).toString());
            // 使用URL实体转换工具
            httpPost.setEntity(stringEntity);
            CloseableHttpResponse execute = aDefault.execute(httpPost);
            System.out.println("---------------" + EntityUtils.toString(execute.getEntity(), "UTF-8"));
        }
    }

    // @Test
    public void testUpload() {
        RestTemplate template = new RestTemplate();
        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("file-data", new ClassPathResource("application-config/springmvc.xml"));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new    HttpEntity<LinkedMultiValueMap<String, Object>>(
            map, headers);
        ResponseEntity<String> result = template.exchange(
            getUrl("multipart"), HttpMethod.POST, requestEntity,
            String.class);
    }
}
