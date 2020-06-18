package com.application.spring5.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class PerformAnalyticsAspect {
	
	@Before("com.application.spring5.aspect.PointcutExprestionUtil.forDaoPackageExcludingGetSet()")
	public void performApiAdvice() {
		System.out.println("\n==2=>>> Performing New Advice Work");
	}

}
