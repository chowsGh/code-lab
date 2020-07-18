package top.clydezhou.lab.demo.spring.web.controller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * 需要添加
 * <dependency>
 *     <groupId>commons-fileupload</groupId>
 *     <artifactId>commons-fileupload</artifactId>
 * </dependency>
 * 依赖
 *
 * @author clyde
 * @date 2020-07-12 21:54
 */
@RestController
@RequestMapping("/multipart")
public class MultiPartController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MultiPartController.class);

    /**
     * RequestPart("meta-data") 封装请求体中的参数例如：
     * Content-Disposition: form-data; name="meta-data"
     * Content-Type: application/json; charset=UTF-8
     * Content-Transfer-Encoding: 8bit
     * {
     * "name": "value"
     * }
     *
     * RequestPart("file-data") MultipartFile 封装请求体中上传的文件
     *
     *
     * @param metadata
     * @param file
     * @return
     */
    @PostMapping("/")
    public String uploadMultipart(@RequestPart(value = "meta-data", required = false) Map<String, String> metadata,
        @RequestPart("file-data") MultipartFile file) {
        try (InputStream inputStream = file.getInputStream()) {
            String fileContent = IOUtils.toString(inputStream);
            LOGGER.info("MultipartFile content:{}", fileContent);
        } catch (IOException e) {
            LOGGER.error("uploadMultipart exception.", e);
        }
        return "MultiPartController";
    }
}
