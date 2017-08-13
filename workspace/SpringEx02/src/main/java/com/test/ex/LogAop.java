package com.test.ex;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {

	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable{
		
		String str=joinpoint.getSignature().toShortString();
		System.out.println(str + "is start");
		long s=System.currentTimeMillis();
		
		
		try{
			System.out.println("A");
			Object obj=joinpoint.proceed();
			System.out.println("B");
			return obj;
		}finally{
			long e=System.currentTimeMillis();
			System.out.println(str + "finished");
			System.out.println("e - s = " + (e-s));
		}
		
		
	}
}
