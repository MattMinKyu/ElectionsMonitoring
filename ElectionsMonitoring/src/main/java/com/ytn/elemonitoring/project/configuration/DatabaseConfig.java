package com.ytn.elemonitoring.project.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value = "com.ytn.elemonitoring.project.dao")
public class DatabaseConfig {

	@Bean(name = "dbDataSource")
	public DataSource RouterDataSource() {
		Map<Object, Object> targetSources = new HashMap<>();
        // `AbstractRoutingDataSource` 에서 반환하는 키 값과 동일하다.
        targetSources.put("user1", getOracleDB1DataSource());
		targetSources.put("user2", getOracleDB2DataSource());
		targetSources.put("user3", getOracleDB3DataSource());
		targetSources.put("user4", getOracleDB4DataSource());
		targetSources.put("user5", getOracleDB5DataSource());
		targetSources.put("user6", getOracleDB6DataSource());
		targetSources.put("user7", getOracleDB7DataSource());
		targetSources.put("dev", getOracleDBDevDataSource());
		targetSources.put("prod", getOracleDBProdDataSource());

        MyRoutingDataSource dataSource = new MyRoutingDataSource();
		dataSource.setTargetDataSources(targetSources);
		return dataSource;
	}

    private DataSource getOracleDB1DataSource() {
		com.zaxxer.hikari.HikariDataSource dataSource = new com.zaxxer.hikari.HikariDataSource();
		// ... driver, username, password 생략
		dataSource.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		dataSource.setJdbcUrl("jdbc:oracle:thin:@10.10.9.169:1521/ORCL");
		dataSource.setUsername("YTN_ELECT");
		dataSource.setPassword("TRI_ELECT");
		return dataSource;
	}

	private DataSource getOracleDB2DataSource() {
		com.zaxxer.hikari.HikariDataSource dataSource = new com.zaxxer.hikari.HikariDataSource();
		// ... driver, username, password 생략
		// jdbc:mysql://localhost:3306/replicaDB?autoReconnect=true&useSSL=false
		dataSource.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("c##mattmk2");
		dataSource.setPassword("1004");
		return dataSource;
	}
	
	private DataSource getOracleDB3DataSource() {
		com.zaxxer.hikari.HikariDataSource dataSource = new com.zaxxer.hikari.HikariDataSource();
		// ... driver, username, password 생략
		// jdbc:mysql://localhost:3306/replicaDB?autoReconnect=true&useSSL=false
		dataSource.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("c##mattmk3");
		dataSource.setPassword("1004");
		return dataSource;
	}
	
	private DataSource getOracleDB4DataSource() {
		com.zaxxer.hikari.HikariDataSource dataSource = new com.zaxxer.hikari.HikariDataSource();
		// ... driver, username, password 생략
		// jdbc:mysql://localhost:3306/replicaDB?autoReconnect=true&useSSL=false
		dataSource.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("c##mattmk4");
		dataSource.setPassword("1004");
		return dataSource;
	}
	
	private DataSource getOracleDB5DataSource() {
		com.zaxxer.hikari.HikariDataSource dataSource = new com.zaxxer.hikari.HikariDataSource();
		// ... driver, username, password 생략
		// jdbc:mysql://localhost:3306/replicaDB?autoReconnect=true&useSSL=false
		dataSource.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("c##mattmk5");
		dataSource.setPassword("1004");
		return dataSource;
	}
	
	private DataSource getOracleDB6DataSource() {
		com.zaxxer.hikari.HikariDataSource dataSource = new com.zaxxer.hikari.HikariDataSource();
		// ... driver, username, password 생략
		// jdbc:mysql://localhost:3306/replicaDB?autoReconnect=true&useSSL=false
		dataSource.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("c##mattmk6");
		dataSource.setPassword("1004");
		return dataSource;
	}
	
	private DataSource getOracleDB7DataSource() {
		com.zaxxer.hikari.HikariDataSource dataSource = new com.zaxxer.hikari.HikariDataSource();
		// ... driver, username, password 생략
		// jdbc:mysql://localhost:3306/replicaDB?autoReconnect=true&useSSL=false
		dataSource.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("c##mattmk7");
		dataSource.setPassword("1004");
		return dataSource;
	}
	
	
	private DataSource getOracleDBDevDataSource() {
		com.zaxxer.hikari.HikariDataSource dataSource = new com.zaxxer.hikari.HikariDataSource();
		// ... driver, username, password 생략
		// jdbc:mysql://localhost:3306/replicaDB?autoReconnect=true&useSSL=false
		dataSource.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		dataSource.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@10.10.9.169:1521/ORCL");
		dataSource.setUsername("YTN_ELECT");
		dataSource.setPassword("TRI_ELECT");
		return dataSource;
	}
	
	private DataSource getOracleDBProdDataSource() {
		com.zaxxer.hikari.HikariDataSource dataSource = new com.zaxxer.hikari.HikariDataSource();
		// ... driver, username, password 생략
		// jdbc:mysql://localhost:3306/replicaDB?autoReconnect=true&useSSL=false
		dataSource.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		dataSource.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@10.10.9.169:1521/ORCL");
		dataSource.setUsername("YTN220309R");
		dataSource.setPassword("TRI220309R");
		return dataSource;
	}
	
	@Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Autowired @Qualifier("dbDataSource") DataSource dataSource,
                                               ApplicationContext applicationContext) throws Exception {

        SqlSessionFactoryBean factoryBean = new RefreshableSqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setTypeAliasesPackage("com.ytn.elemonitoring.project.dto");
        factoryBean.setConfigLocation(applicationContext.getResource("classpath:mybatis-config.xml"));
        factoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/mapper/*.xml"));
        ((RefreshableSqlSessionFactoryBean) factoryBean).setInterval(1000);

        return factoryBean.getObject();
    }

}