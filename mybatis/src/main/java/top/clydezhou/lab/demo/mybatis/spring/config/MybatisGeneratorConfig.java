package top.clydezhou.lab.demo.mybatis.spring.config;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.ModelType;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author clyde
 * @date 2020-07-20 22:15
 */
public class MybatisGeneratorConfig {

    public static void main(String[] args)
        throws InterruptedException, SQLException, IOException, InvalidConfigurationException, XMLParserException,
        URISyntaxException {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        URL resource = MybatisGeneratorConfig.class.getClassLoader().getResource("generatorConfig.xml");
        System.out.println(resource);
        System.out.println(new File("generatorConfig.xml").getAbsolutePath());
        File configFile = new File(resource.toURI());
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);

//        Configuration config = new Configuration();
//        Context context = new Context(ModelType.CONDITIONAL);
//        config.addContext(context);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        System.out.println(warnings);
    }
}
