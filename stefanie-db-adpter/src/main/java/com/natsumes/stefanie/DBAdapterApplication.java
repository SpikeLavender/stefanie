package com.natsumes.stefanie;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@MapperScan("com.natsumes.stefanie.mapper")
@RefreshScope
public class DBAdapterApplication {

    public static void main(String[] args) {
        SpringApplication.run(DBAdapterApplication.class, args);
    }

}
