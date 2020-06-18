package com.application.spring5.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class CloudAspect {
	
	@Before("com.application.spring5.aspect.PointcutExprestionUtil.forDaoPackageExcludingGetSet()")
	public void loggingCloudAdvice() {
		System.out.println("\n==3=>>> Logging cloud  advice");
	}

}
