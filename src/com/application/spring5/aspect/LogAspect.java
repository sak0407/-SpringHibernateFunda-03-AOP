package com.application.spring5.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.application.spring5.Account;

@Aspect
@Component
@Order(1)
public class LogAspect {
	
	//Ordering Advice
	//----------------
	/*
	@Before("com.application.spring5.aspect.PointcutExprestionUtil.forDaoPackageExcludingGetSet()")
	public void logAdvice() {
		System.out.println("\n==1=>>> Executing @Before advice on add*()");
		
  	}
	*/
	
	//JointPoints --Accessing method information
	//------------------------------------------
	
	@Before("com.application.spring5.aspect.PointcutExprestionUtil.forDaoPackageExcludingGetSet()")
	public void logAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n==1=>>> Executing @Before advice on add*()");
		
		//display the method signature
		
		MethodSignature methodSignature=(MethodSignature)theJoinPoint.getSignature();
		
		System.out.println("Method Sig : "+methodSignature);		
		
		//display method arguments
		Object[] args=theJoinPoint.getArgs();
		
		for(Object theAgr:args) {
			System.out.println(theAgr);
			
			if(theAgr instanceof Account) {
				Account theAccount=(Account) theAgr;
				System.out.println("Account name : "+theAccount.getName());
				System.out.println("Level: "+theAccount.getLevel());
			}
		}
		
		
  	}

}




































