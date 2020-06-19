package com.application.spring5.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	private static Logger myLogger =
			Logger.getLogger(LogAspect.class.getName());
	// Ordering Advice
	// ----------------
	/*
	 * @Before(
	 * "com.application.spring5.aspect.PointcutExprestionUtil.forDaoPackageExcludingGetSet()")
	 * public void logAdvice() {
	 * myLogger.info("\n==1=>>> Executing @Before advice on add*()");
	 * 
	 * }
	 */

	// JointPoints --Accessing method information
	// ------------------------------------------

	@Before("com.application.spring5.aspect.PointcutExprestionUtil.forDaoPackageExcludingGetSet()")
	public void logAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n==1=>>> Executing @Before advice on add*()");

		// display the method signature

		MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

		myLogger.info("Method Sig : " + methodSignature);

		// display method arguments
		Object[] args = theJoinPoint.getArgs();

		for (Object theAgr : args) {
			myLogger.info(theAgr.toString());

			if (theAgr instanceof Account) {
				Account theAccount = (Account) theAgr;
				myLogger.info("Account name : " + theAccount.getName());
				myLogger.info("Level: " + theAccount.getLevel());
			}
		}

	}

	// After Returning Advice ,On find Accounts mathod
	// ---------------------------------------------------------

	@AfterReturning(pointcut = "execution (* com.application.spring5.dao.AccountDAO.findAccounts(..) )", returning = "resultY")
	public void afterreturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> resultY) {

		String methodString = joinPoint.getSignature().toShortString();

		myLogger.info("\n====>>> Executing @AfterReturning advice on " + methodString);

		myLogger.info("\n----->> Result is : " + resultY);

		myLogger.info(" -- ------------------------ --");

		myLogger.info(" : Post Proccessing of data :");

		if (!resultY.isEmpty()) {
			Account tempAccount = resultY.get(0);
			tempAccount.setName("Ram");
		}

		myLogger.info("\n====>>>Modified result is : " + resultY);

		myLogger.info(" -- ------------------------ --");

		myLogger.info(" : Convert the names to upddercase :");

		convertAccountNamestoUppercase(resultY);

		myLogger.info("\n====>>>Modified result is : " + resultY);

	}

	private void convertAccountNamestoUppercase(List<Account> resultY) {

		for (Account theAccount : resultY) {
			String theUssernameString = theAccount.getName().toUpperCase();

			theAccount.setName(theUssernameString);
		}

	}

	// After Throwing Advice ,On find Accounts mathod
	// ---------------------------------------------------------

	@AfterThrowing(pointcut = "execution (* com.application.spring5.dao.AccountDAO.findAccountsWithException(..) )", throwing = "excepTn")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable excepTn) {

		// print out which method we are advising on
		String methodString = joinPoint.getSignature().toShortString();

		myLogger.info("\n====>>> Executing @AfterThrowing advice on " + methodString);

		// log the exception

		myLogger.info("\n----->>> The Exception is " + excepTn);

	}

	// After Advice ,Its kind of finnaly Advice,which run must and before throwing
	// excep.
	// ----------------------------------------------------------------------------------

	@After("execution (* com.application.spring5.dao.AccountDAO.findAccountsWithAfter(..) )")
	public void afterFinnllyFindAccountsAdvice(JoinPoint joinPoint) {

		// print out which method we are advising on
		String methodString = joinPoint.getSignature().toShortString();

		myLogger.info("\n====>>> Executing @After(Finally) advice on " + methodString);

		// log the exception

		myLogger.info("\n----->>> The Exception is " + methodString);

	}

	// Around Advice - (Befor + After)
	//ProceedingJoinPoint- works on traget method /handle on traget method
	// ----------------------------------------------------------------------------------

	@Around("execution (* com.application.spring5.service.*.getFortune(..) )")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
	     //print out which method we are advising on
		String methodString = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n====>>> Executing @Around advice on " + methodString);

		//get begin timestamp
		long begin=System.currentTimeMillis();
		
		//execute the methode
		Object result= theProceedingJoinPoint .proceed();
		
		//get end the timestamp
		long end =System.currentTimeMillis();
		
		//compute duration and display 
		long duration = end- begin;
		myLogger.info(" \n====>>> Duration "+duration / 1000.0 + "seconds");
		return result;

	}
	
	// Around Advice - Handling exception
	// it has capability to handle the exception
	// ----------------------------------------------------------------------------------

	@Around("execution (* com.application.spring5.service.*.getFortuneException(..) )")
	public Object aroundGetFortuneExceptionHandling(ProceedingJoinPoint theProceedingJoinPoint) {

		// print out which method we are advising on
		String methodString = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n====>>> Executing @Around advice on " + methodString);

		// get begin timestamp
		long begin = System.currentTimeMillis();

		// execute the methode
		Object result = null;
				
		try {
			result= theProceedingJoinPoint.proceed();
		} catch (Throwable e) {			
			myLogger.warning(e.getMessage());
			
			result = "Major Accident ! But no worries , your private Aop helicopter is on the way";
		}

		// get end the timestamp
		long end = System.currentTimeMillis();

		// compute duration and display
		long duration = end - begin;
		myLogger.info(" \n====>>> Duration " + duration / 1000.0 + "seconds");
		return result;

	}
	
	// Around Advice -Exception rethrow to main method
	// it has capability to rethrow the exception
	// ----------------------------------------------------------------------------------

	@Around("execution (* com.application.spring5.service.*.getFortuneExceptionRethrow(..) )")
	public Object aroundGetFortuneExceptionRethrowToMain(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

		// print out which method we are advising on
		String methodString = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n====>>> Executing @Around advice(Exception Rethrow) on " + methodString);

		// get begin timestamp
		long begin = System.currentTimeMillis();

		// execute the methode
		Object result = null;

		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Throwable e) {
			myLogger.warning(e.getMessage());

			throw e;
		}

		// get end the timestamp
		long end = System.currentTimeMillis();

		// compute duration and display
		long duration = end - begin;
		myLogger.info(" \n====>>> Duration " + duration / 1000.0 + "seconds");
		return result;

	}

}





















