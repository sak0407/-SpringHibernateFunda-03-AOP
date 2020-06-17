package com.application.spring5.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {
	
	//this is where we add all of our related advises for logging
	
	//@Before advice	
	//-----------------------------
	@Before("execution (public void addAccount())")
	public void beforeAddAdvice() {
		System.out.println("\n===>>> Executing @Before advice on addAccount()");
  	} 
 	
 

}
