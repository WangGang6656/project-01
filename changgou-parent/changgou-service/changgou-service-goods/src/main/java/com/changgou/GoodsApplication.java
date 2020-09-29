package com.changgou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

//必须先启动Eureka,在启动其他微服务，不然会报错！

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.changgou.dao"})
//与接口一致，使用通用Mapper
public class GoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class,args);
    }
}
