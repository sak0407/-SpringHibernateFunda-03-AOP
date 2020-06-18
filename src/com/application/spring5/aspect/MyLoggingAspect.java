package com.application.spring5.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {
	
	//This is where we add all of our related advises for logging
	
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
	
   // Pointcut match with return type
	//---------------------------------
	
	/*@Before("execution (* add*())")
	public void beforeAddAdvice() {
		System.out.println("\n===>>> Executing @Before advice on add*()");
  	}*/
	
	//Match on method parameters
	//---------------------------
		
	/*@Before("execution (* add*(com.application.spring5.Account))")
	public void beforeAddAdvice() {
		System.out.println("\n===>>> Executing @Before advice on add*()");
  	}*/
	
	
	//Match on method parameters with any no of arguments(using wildcards)
	//--------------------------------------------------------------------
	
	/*@Before("execution (* add*(com.application.spring5.Account,..))")
	public void beforeAddAdvice() {
		System.out.println("\n===>>> Executing @Before advice on add*()");
  	}*/
	
	/*@Before("execution (* add*(..))")
	public void beforeAddAdvice() {
		System.out.println("\n===>>> Executing @Before advice on add*()");
  	}*/
	
	
	//Match on package
	//----------------
	
	@Before("execution (* com.application.spring5.dao.*.*(..))")
	public void beforeAddAdvice() {
		System.out.println("\n===>>> Executing @Before advice on add*()");
  	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
