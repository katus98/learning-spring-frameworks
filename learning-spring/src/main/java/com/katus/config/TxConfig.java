package com.katus.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-26
 */
@Configuration
@ComponentScan(basePackages = {"com.katus"})
@EnableTransactionManagement
public class TxConfig {
    @Bean
    public DruidDataSource getDataSource() {
        Properties prop = new Properties();
        DruidDataSource dataSource = new DruidDataSource();
        FileInputStream stream = null;
        try {
            stream = new FileInputStream("src/main/resources/db.properties");
            prop.load(stream);
            dataSource.setDriverClassName(prop.getProperty("db.driverClassName"));
            dataSource.setUrl(prop.getProperty("db.url"));
            dataSource.setUsername(prop.getProperty("db.username"));
            dataSource.setPassword(prop.getProperty("db.password"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(dataSource);
        return template;
    }

    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
