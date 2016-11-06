package com.beren.qbademo.db;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackageClasses = MailRepository.class)
public class DbConfig {
	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		builder = builder.setType(EmbeddedDatabaseType.H2);
		builder.addDefaultScripts();
		EmbeddedDatabase build = builder.build();
		return build;
	}

	// @Bean
	// public LocalContainerEntityManagerFactoryBean
	// entityManagerFactory(DataSource dataSource,
	// JpaVendorAdapter jpaVendorAdapter) {
	// LocalContainerEntityManagerFactoryBean lef = new
	// LocalContainerEntityManagerFactoryBean();
	// lef.setDataSource(dataSource);
	// lef.setJpaVendorAdapter(jpaVendorAdapter);
	// lef.setPackagesToScan("com.beren.qbademo.entities");
	// return lef;
	// }
	//
	// @Bean
	// public JpaVendorAdapter jpaVendorAdapter() {
	// HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new
	// HibernateJpaVendorAdapter();
	// hibernateJpaVendorAdapter.setShowSql(false);
	// hibernateJpaVendorAdapter.setGenerateDdl(false);
	// hibernateJpaVendorAdapter.setDatabase(Database.H2);
	// return hibernateJpaVendorAdapter;
	// }

}
