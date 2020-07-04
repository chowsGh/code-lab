package top.clydezhou.lab.demo.spring.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.text.SimpleDateFormat;

/**
 * @author clyde
 * @date 2020-07-03 0:04
 */
public class JsonUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtils.class);

    private static ObjectMapper objectMapper;

    static {
        Jackson2ObjectMapperBuilder builder =
            new Jackson2ObjectMapperBuilder().dateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        //            .indentOutput(true)
        //            .modulesToInstall(new ParameterNamesModule());
        objectMapper = builder.build();
    }

    public static String toJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            LOGGER.error("toJson exception.", obj, e);
        }
        return "";
    }
}
