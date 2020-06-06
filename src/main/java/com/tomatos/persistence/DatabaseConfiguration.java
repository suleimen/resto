package com.tomatos.persistence;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@Configuration
@EntityScan(basePackages = {"com.tomatos.persistence.domain"})
@EnableJpaRepositories({"com.tomatos.persistence.repository"})
@EnableTransactionManagement
public class DatabaseConfiguration {

    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:liquibase/changeset.xml");
        liquibase.setDataSource(dataSource);

        return liquibase;
    }


}
