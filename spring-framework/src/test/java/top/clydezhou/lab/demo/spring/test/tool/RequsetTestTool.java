package top.clydezhou.lab.demo.spring.test.tool;

import static org.junit.Assert.assertTrue;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.*;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import top.clydezhou.lab.demo.spring.entity.UserInfo;
import top.clydezhou.lab.demo.spring.utils.JsonUtils;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class RequsetTestTool {

    public static final String BASE_URL = "http://localhost:8080/spring-framework/java-config-servlet";

    public static String getUrl(String url) {
        return BASE_URL + url;
    }
}
