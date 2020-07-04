/**
 * 
 */
package top.clydezhou.lab.demo.spring.config.database;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import top.clydezhou.lab.demo.spring.config.database.MysqlDataSourceConfig;
import top.clydezhou.lab.demo.spring.entity.Gender;
import top.clydezhou.lab.demo.spring.mapper.UserMapper;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * The type Mybatis my sql config.
 *
 * @date 2020.06.16 23:34:27
 */
@Configuration
//@MapperScan("top.clydezhou.lab.demo.spring.mapper")
public class MybatisMySqlConfig {

    @Resource
    private MysqlDataSourceConfig dataSourceConfig;

    /* 等同于 @MapperScan
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("top.clydezhou.example.lab.mapper");
        return mapperScannerConfigurer;
    }*/

    @Bean
    public UserMapper mysqlUserMapper() throws Exception {
        MapperFactoryBean<UserMapper> mapperBean = new MapperFactoryBean<>(UserMapper.class);
        mapperBean.setSqlSessionFactory(mysqlSessionFactory());
        return mapperBean.getObject();
    }
    
    /**
     * 通过 @Bean 注解的形式，使用 SqlSessionFactoryBean 工厂类创建 SqlSessinoFactory.
     * mybatis 的基础配置可以通过 xml 或者 Java Configuration 的形式设置到 SqlSeesionFactory
     * 直接引用 dataSource() 方法注入的数据源。
     *
     * @return the sql session factory
     * @throws Exception the exception
     */
    @Bean
    public SqlSessionFactory mysqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver =
            new PathMatchingResourcePatternResolver();
        factoryBean
            .setMapperLocations(pathMatchingResourcePatternResolver.getResources("classpath:mappers/*Mapper.xml"));
        // mybatis config，也可以使用 xml 配置
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.getTypeHandlerRegistry().register(Gender.class, new EnumOrdinalTypeHandler<>(Gender.class));
        factoryBean.setConfiguration(configuration);
        return factoryBean.getObject();
    }

    
    /**
     * 使用 @Bean 的形式在 Spring 容器中创建数据源。
     *
     * @return the data source
     */
    @Bean
    public DataSource dataSource() {
        HikariDataSource source = new HikariDataSource();
        source.setDriverClassName(dataSourceConfig.getDriverClassName());
        source.setJdbcUrl(dataSourceConfig.getJdbcUrl());
        source.setUsername(dataSourceConfig.getUsername());
        source.setPassword(dataSourceConfig.getPassword());
        return source;
    }
}
