package ru.agronomych.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;

@Configuration
public class SpringJDBCConfig {

    @Bean
    @DependsOn("dataSource")
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        var jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean
    @DependsOn("dataSource")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        var namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        return namedParameterJdbcTemplate;
    }

    @Bean
    @DependsOn("dataSource")
    public SimpleJdbcInsert simpleJdbcInsert(DataSource dataSource) {
        var simpleJdbcInsert = new SimpleJdbcInsert(dataSource);
        return simpleJdbcInsert;
    }

    @Bean
    @DependsOn("dataSource")
    public SimpleJdbcCall simpleJdbcCall(DataSource dataSource) {
        var simpleJdbcCall = new SimpleJdbcCall(dataSource);
        return simpleJdbcCall;
    }
}