/**
 * 
 */
package top.clydezhou.lab.demo.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author chows
 * Date:2019-12-27 12:12:29
 */
@Component
public class MysqlDataSourceConfig {
    @Value("${dataSource.mysql.driverClassName}")
    private String driverClassName;
    @Value("${dataSource.mysql.jdbcUrl}")
    private String jdbcUrl;
    @Value("${dataSource.mysql.username}")
    private String username;
    @Value("${dataSource.mysql.password}")
    private String password;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
