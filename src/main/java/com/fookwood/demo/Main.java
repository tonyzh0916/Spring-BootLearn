package com.fookwood.demo;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fasterxml.jackson.databind.cfg.ConfigFeature;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigFeature.class);
		
		C c = context.getBean(C.class);
		System.out.println(c.getA() != null);
	}

}
