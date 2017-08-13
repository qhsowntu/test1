package com.test.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

//9장
public class MainClass {
	public static void main(String[] args){
		
		
		AbstractApplicationContext ctx=new GenericXmlApplicationContext("classpath:appCTX.xml");
		Student st = ctx.getBean("student",Student.class);
		
		st.getInfo();
		
	}
	
}
