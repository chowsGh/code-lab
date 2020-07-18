package top.clydezhou.lab.demo.spring.config.database;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author clyde
 * @date 2020-06-30 22:54
 */
@Configuration
// 开启声明式事务，支持使用 @Transactional 注解声明事务
@EnableTransactionManagement
public class TransactionConfig {
    // key to the Spring transaction abstraction is the notion of a transaction strategy. A transaction strategy is defined by a TransactionManager, specifically the org.springframework.transaction.PlatformTransactionManager

    @Resource(name = "mysqlDataSource")
    private DataSource mysqlDataSource;
    /**
     * mysql 事务管理器，
     *
     * @return
     */
    @Bean
    public TransactionManager mysqlTransactionManager() {
        DataSourceTransactionManager manager = new DataSourceTransactionManager();
        manager.setDataSource(mysqlDataSource);
        return manager;
    }
}
