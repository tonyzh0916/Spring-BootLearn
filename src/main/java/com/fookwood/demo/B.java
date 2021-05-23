package com.fookwood.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //这个注解就表示了它所在的类是组件，需要初始化Bean。
public class B {

	@Autowired
	private D d;
	
	public D getD() {
		return d;
	}
}
