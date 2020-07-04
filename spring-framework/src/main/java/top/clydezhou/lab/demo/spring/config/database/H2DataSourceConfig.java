/**
 * 
 */
package top.clydezhou.lab.demo.spring.config.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author chows
 * Date:2019-12-27 12:12:29
 */
@Component
public class H2DataSourceConfig {
    @Value("${dataSource.h2DataSource.driverClassName}")
    private String driverClassName;
    @Value("${dataSource.h2DataSource.jdbcUrl}")
    private String jdbcUrl;
    @Value("${dataSource.h2DataSource.username}")
    private String username;
    @Value("${dataSource.h2DataSource.password}")
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
