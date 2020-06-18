package com.application.spring5.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
	
	//---------------------------------------
	//PointCut Expression
	//---------------------------------------
 	
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
	
	/*
	@Before("execution (* add*())")
	public void beforeAddAdvice() {
		System.out.println("\n===>>> Executing @Before advice on add*()");
  	}
  	*/
	
	//Match on method parameters
	//---------------------------
		
	/*
	@Before("execution (* add*(com.application.spring5.Account))")
	public void beforeAddAdvice() {
		System.out.println("\n===>>> Executing @Before advice on add*()");
  	}
  	*/
	
	
	//Match on method parameters with any no of arguments(using wildcards)
	//--------------------------------------------------------------------
	
	/*
	@Before("execution (* add*(com.application.spring5.Account,..))")
	public void beforeAddAdvice() {
		System.out.println("\n===>>> Executing @Before advice on add*()");
  	}
  	*/
	
	/*@Before("execution (* add*(..))")
	public void beforeAddAdvice() {
		System.out.println("\n===>>> Executing @Before advice on add*()");
  	}*/
	
	
	//Match on package
	//----------------
	
	/*
	@Before("execution (* com.application.spring5.dao.*.*(..))")
	public void beforeAddAdvice() {
		System.out.println("\n===>>> Executing @Before advice on add*()");
  	}
  	*/
	
	
	//----------------------------------------------------------
	//PointCut Declaration
	//----------------------------------------------------------
	
	/*
	@Pointcut("execution (* com.application.spring5.dao.*.*(..))")
	private void forDaoPackage() {}
	
	
	@Before("forDaoPackage()")
	public void beforeAddAdvice() {
		System.out.println("\n==1=>>> Executing @Before advice on add*()");
  	}
	
	@Before("forDaoPackage()")
	public void performApi() {
		System.out.println("\n==2=>>> Performing New Advice Work");
	}
	
	*/
	//---------------------------------------------------
	//Apply multiple pointcut expressions to single advice
	// dont want to apply advice on getter and setter
	//---------------------------------------------------
	
	/*
	
	@Pointcut("execution (* com.application.spring5.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution (* com.application.spring5.dao.*.get*(..))")
	private void getter() {}
	
	@Pointcut("execution (* com.application.spring5.dao.*.set*(..))")
	private void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter()||setter())")
	private void forDaoPackageExcludingGetSet() {}
	
	@Before("forDaoPackageExcludingGetSet()")
	public void beforeAddAdvice() {
		System.out.println("\n==1=>>> Executing @Before advice on add*()");
  	}
	
	@Before("forDaoPackageExcludingGetSet()")
	public void performApi() {
		System.out.println("\n==2=>>> Performing New Advice Work");
	}
	
	*/
	
	//---------------------------------------
	//Controlling the order of aspects
	// Here order will be Undefined
	//Next step ---do code refactoring
	//---------------------------------------
	
	/*
	@Pointcut("execution (* com.application.spring5.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution (* com.application.spring5.dao.*.get*(..))")
	private void getter() {}
	
	@Pointcut("execution (* com.application.spring5.dao.*.set*(..))")
	private void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter()||setter())")
	private void forDaoPackageExcludingGetSet() {}
	
	@Before("forDaoPackageExcludingGetSet()")
	public void logAdvice() {
		System.out.println("\n==1=>>> Executing @Before advice on add*()");
  	}
	
	@Before("forDaoPackageExcludingGetSet()")
	public void performApiAdvice() {
		System.out.println("\n==2=>>> Performing New Advice Work");
	}
	
	@Before("forDaoPackageExcludingGetSet()")
	public void loggingCloudAdvice() {
		System.out.println("\n==3=>>> Logging cloud  advice");
	}
	
	*/
	
	
}	
	
	

