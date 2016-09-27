package com.mum.service;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class MonitorService {

	public MonitorService() {
		// TODO Auto-generated constructor stub
	}

	@Before("execution(* com.mum.service.*.*(..))") 
	public void anyOldTransfer() {
		//System.out.println("----Before Start----");
	}
	/**
	 * Check User Permission
	 */
	@Before("execution(* com.mum.controller.*.*(..))")
	public void userPermission(){
		System.out.println("----Check User Permission----");
		System.out.println("----Permission Pass----");
	}
	
	/**
	 * Monitor the Service running time
	 * @param call
	 * @return object
	 * @throws Throwable
	 */
	@Around("execution(* com.mum.service.*.*(..))") 
	public Object runningTime(ProceedingJoinPoint call) throws Throwable {
		StopWatch clock = new StopWatch("timmer");
		clock.start(call.toShortString());
		Object object = call.proceed();
		clock.stop();
		System.out.println(clock.prettyPrint());
		return object;

	}

}
