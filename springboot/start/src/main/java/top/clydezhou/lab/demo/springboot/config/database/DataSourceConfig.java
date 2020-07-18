/**
 *
 */
package top.clydezhou.lab.demo.springboot.config.database;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author chows
 * Date:2019-12-27 12:12:29
 */
// ConfigurationProperties 用于注入相应的配置，不支持 驼峰形式的key,需要使用 短横线形式的key 例如 ： data-source 形式。
// 同时可以用于 生成 metadata，方便 ide 提示配置
@ConfigurationProperties(prefix = "datasource.mysql")
public class DataSourceConfig {
    private String driverClassName;
    private String jdbcUrl;
    private String username;
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

    @Override
    public String toString() {
        return "DataSourceConfig{" + "driverClassName='" + driverClassName + '\'' + ", jdbcUrl='" + jdbcUrl + '\''
            + ", username='" + username + '\'' + ", password='" + password + '\'' + '}';
    }
}
