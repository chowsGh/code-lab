package top.clydezhou.lab.demo.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * sping 基于xml配置文件的 应用demo
 * 
 * @author chows Date:2019-12-22 02:12:01
 */
public class XmlConfigBasedApplication {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("application-config/applicationContext.xml")) {
        }
    }
}
