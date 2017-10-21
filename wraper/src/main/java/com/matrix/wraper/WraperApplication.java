package com.matrix.wraper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

@ServletComponentScan
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@MapperScan("dao") //这里mapper是你的mybatis的mapper目录。
public class WraperApplication {

	public static void main(String[] args) {
		SpringApplication.run(WraperApplication.class, args);
	}
}
