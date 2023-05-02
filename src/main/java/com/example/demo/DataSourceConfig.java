package com.example.demo;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
//    @Bean
//    public DataSource getDataSource(){
//        return DataSourceBuilder.create()
//                .driverClassName("com.mysql.jdbc.Driver")
//                .url("jdbc:mysql://localhost:3306/BMS")
//                .username("root")
//                .password("shivanim122")
//                .build();
//    }
}
