package ru.agronomych.config;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.sql.DataSource;

/**
 * LiquibaseConfig
 *
 * @author Anton_Suryain
 */
@Configuration
@DependsOn("dataSource")
public class LiquibaseConfig {

    @Bean
    SpringLiquibase getSpringLiquibase(DataSource dataSource) {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setChangeLog("classpath:db/changelog/changelog-master.xml");
        return liquibase;
    }
}