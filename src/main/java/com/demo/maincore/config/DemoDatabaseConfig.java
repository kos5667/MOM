package com.demo.maincore.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@MapperScan(basePackages = "com.demo.main.mapper", sqlSessionFactoryRef = "demoSqlSessionFactory")
@EnableTransactionManagement
public class DemoDatabaseConfig {

	@Primary
	@Bean(name = "demoDataSource")
	@ConfigurationProperties(prefix = "spring.demo.datasource")
	public DataSource demoDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean(name = "demoSqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("demoDataSource") DataSource demoDataSource)
			throws IOException, Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(demoDataSource);
		sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*.xml"));
		Resource myBatisConfig = new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml");
		sqlSessionFactory.setConfigLocation(myBatisConfig);
		return sqlSessionFactory.getObject();
	}

	@Primary
	@Bean(name = "demoSqlSessionTemplate")
	public SqlSessionTemplate sqlSession(@Qualifier("demoSqlSessionFactory") SqlSessionFactory demoSqlSessionFactory) {
		
		return new SqlSessionTemplate(demoSqlSessionFactory);
	}

	/**
	 * 트랜잭션 매니저 설정
	 */
	@Primary
	@Bean(name = "demoTransactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("demoDataSource") DataSource demoDataSource) {
		return new DataSourceTransactionManager(demoDataSource);
	}
}
