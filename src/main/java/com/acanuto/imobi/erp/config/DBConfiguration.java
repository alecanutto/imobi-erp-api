package com.acanuto.imobi.erp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DBConfiguration {

	private String driverClassName;
	private String url;
	private String username;
	private String password;

	@Bean
	@Primary
	public DataSource postgreSqlDataSource() {
		return DataSourceBuilder.create().url("jdbc:postgresql://localhost:5432/Imobiliaria_DB").username("postgres")
				.password("123").build();
	}
	
}
