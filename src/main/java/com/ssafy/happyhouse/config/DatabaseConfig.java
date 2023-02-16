package com.ssafy.happyhouse.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//DB클래스 설정 파일에 매퍼의 경로를 설정해준다
@MapperScan(
		basePackages = "com.ssafy.happyhouse.mapper"
)
public class DatabaseConfig {}