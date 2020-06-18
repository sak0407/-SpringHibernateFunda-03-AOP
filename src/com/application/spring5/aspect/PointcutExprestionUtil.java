package com.application.spring5.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutExprestionUtil {
	
	@Pointcut("execution (* com.application.spring5.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution (* com.application.spring5.dao.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution (* com.application.spring5.dao.*.set*(..))")
	public void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter()||setter())")
	public void forDaoPackageExcludingGetSet() {}

}
