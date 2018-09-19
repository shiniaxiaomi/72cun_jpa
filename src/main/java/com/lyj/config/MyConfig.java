package com.lyj.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Created by Yingjie.Lu on 2018/9/17.
 */


@EnableTransactionManagement    //开启声明式事务管理
@Configuration
public class MyConfig {

    @Autowired
    private ConfigurableEnvironment environment;//注入配置文件管理类

    //配置数据源
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setUser(environment.getProperty("jdbc.username"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));
        dataSource.setDriverClass(environment.getProperty("jdbc.driverClass"));
        dataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        return dataSource;
    }

    //配置声明式事务管理
    @Bean
    public PlatformTransactionManager dataSourceTransactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }

    //配置JdbcTemplate
    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        return new JdbcTemplate(dataSource());
    }



}
