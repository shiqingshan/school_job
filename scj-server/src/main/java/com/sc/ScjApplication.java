package com.sc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sc.persistence.**.dao.mysql")
public class ScjApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScjApplication.class,args);
    }
}
