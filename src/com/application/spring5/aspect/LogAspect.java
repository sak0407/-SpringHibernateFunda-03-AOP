package com.application.spring5.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class LogAspect {
	
	@Before("com.application.spring5.aspect.PointcutExprestionUtil.forDaoPackageExcludingGetSet()")
	public void logAdvice() {
		System.out.println("\n==1=>>> Executing @Before advice on add*()");
  	}

}
