package com.rrx.vbank.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.rrx.vbank.vbankDs.mapper"}, sqlSessionFactoryRef = "vbankSqlSessionFactory")
public class VbankDbAConfig {
    @Autowired
    @Qualifier("vbankds")
    private DataSource ds1;


    @Bean
    public SqlSessionFactory vbankSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean1 = new SqlSessionFactoryBean();
        // 使用titan数据源, 连接titan库
        factoryBean1.setDataSource(ds1);

        return factoryBean1.getObject();

    }

    @Bean
    public SqlSessionTemplate vbankSqlSessionTemplate() throws Exception {
        // 使用上面配置的Factory
        SqlSessionTemplate template1 = new SqlSessionTemplate(vbankSqlSessionFactory());
        return template1;
    }
}
