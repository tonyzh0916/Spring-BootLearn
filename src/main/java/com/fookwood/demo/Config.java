package com.fookwood.demo;

import java.util.TimeZone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@ComponentScan //这个注解表示容器应该去扫描程序的代码，看看那些组件应当被初始化为Bean
@Configuration //这表明Config类是配置类
public class Config {

	@Bean//表示返回的对象会加入到容器中。ObjectMapper对象可以在objectMapper方法里，进行一些修改呀，配置呀等等。
	public ObjectMapper objectMapper() {
		ObjectMapper om = new ObjectMapper();
		om.setTimeZone(TimeZone.getDefault());
		return om;
	}
}
