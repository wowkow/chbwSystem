package com.server.chbw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.server.chbw.*.mapper")//使用MapperScan批量扫描所有的Mapper接口
@EnableTransactionManagement             //开启事务管理
public class ChbwSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChbwSystemApplication.class, args);
	}

}
