package com.wlq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description
 * @Author WangLanQing
 * @Date 2020-02-25-16:05
 */
@SpringBootApplication
@MapperScan("com.wlq.dao")
public class JcartAdministrationBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(JcartAdministrationBackApplication.class,args);
    }
}
