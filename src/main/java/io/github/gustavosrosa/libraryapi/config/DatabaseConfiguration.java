package io.github.gustavosrosa.libraryapi.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatabaseConfiguration {
	
	@Value("${spring.datasource.url}")
	String url;
	
	@Value("${spring.datasource.username}")
	String username;
	
	@Value("${spring.datasource.password}")
	String password;
	
	@Value("${spring.datasource.driver-class-name}")
	String jdbcDriver;
	
	@Value("${spring.datasource.hikari.pool-name}")
	String poolName;
	
	@Value("${spring.datasource.hikari.max-lifetime}")
	Long maxLifetime;
	
	@Value("${spring.datasource.hikari.connection-timeout}")
	Long connectionTimeout;
	
	private final Integer MAX_POOL_SIZE_ACTIVE_CONS = 10;
	private final Integer MIN_START_LENGTH_POOL = 1;

	/**
	 * This datasource is not recommended in production, is necessary to use a connection pool to maintain
	 * a lot of connections
	 * 
	 * @return datasource
	 */
	// @Bean
	DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		
		driverManagerDataSource.setUrl(url);
		driverManagerDataSource.setUsername(username);
		driverManagerDataSource.setPassword(password);
		driverManagerDataSource.setDriverClassName(jdbcDriver);
		
		return driverManagerDataSource;
	}
	
	@Bean
	DataSource hikariDataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		
		/*
		 * Basic configurations
		 */
		hikariConfig.setJdbcUrl(url);
		hikariConfig.setUsername(username);
		hikariConfig.setPassword(password);
		hikariConfig.setDriverClassName(jdbcDriver);
		
		/**
		 * Max free connections to use
		 * 
		 * OBS.: If the software increases memory, the main possibility is the limited pool datasource
		 * 
		 */
		hikariConfig.setMaximumPoolSize(MAX_POOL_SIZE_ACTIVE_CONS);
		
		/**
		 * Start pool length
		 */
		hikariConfig.setMinimumIdle(MIN_START_LENGTH_POOL);
		
		hikariConfig.setPoolName(poolName);
		
		/**
		 * Max lifetime (in millis)
		 */
		hikariConfig.setMaxLifetime(maxLifetime); // Ten minutes
		
		/**
		 * Time which datasource try to connect
		 */
		hikariConfig.setConnectionTimeout(connectionTimeout); // 1.66 min
		
		hikariConfig.setConnectionTestQuery("select 1"); // Test query
		
		return new HikariDataSource(hikariConfig);
		
	}

}
