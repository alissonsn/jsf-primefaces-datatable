package com.codenotfound.primefaces;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


@Configuration
public class DataConfiguration {
	static final String URL = "jdbc:mysql://localhost:3306/location?useSSL=false"; //incica o caminho do banco de dados
	static final String USER = "root"; // aqui vai o nome usuario que vc quer acessar
	static final String PASS = "root"; // aqui a senha do seu banco
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl(URL);
		dataSource.setUsername(USER);//setado no arquivo application.properties
		dataSource.setPassword(PASS);
		return dataSource;
	}
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");
		adapter.setPrepareConnection(true);
		return adapter;
	}

}
