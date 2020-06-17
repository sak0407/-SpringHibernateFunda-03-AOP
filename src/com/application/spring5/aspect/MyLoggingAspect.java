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
	/*@Before("execution (public void addAccount())")
	public void beforeAddAdvice() {
		System.out.println("\n===>>> Executing @Before advice on addAccount()");
  	} */
 	
  // To call only from Account class
  //---------------------------------
	/*@Before("execution (public void com.application.spring5.dao.AccountDAO.addAccount())")
	public void beforeAddAdvice() {
		System.out.println("\n===>>> Executing @Before advice on addAccount()");
  	} */
	
	//PointCut wild card
	//---------------------
	/*@Before("execution (public void add*())")
	public void beforeAddAdvice() {
		System.out.println("\n===>>> Executing @Before advice on add*()");
  	}*/
	
   // pointcut match with return type
	//---------------------------------
	
	@Before("execution (* add*())")
	public void beforeAddAdvice() {
		System.out.println("\n===>>> Executing @Before advice on add*()");
  	}
}
