package com.fookwood.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //这个注解就表示了它所在的类是组件，需要初始化Bean。
public class C {
	
	@Autowired
	private A a;
	
	@Autowired
	private B b;
	
	public A getA() {return a;}
	
	public B getB() {return b;}
}
