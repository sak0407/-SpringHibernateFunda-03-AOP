package com.application.spring5.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	
	
	//After Returning Advice ,On find Accounts mathod
	//---------------------------------------------------------
	
	@AfterReturning(pointcut ="execution (* com.application.spring5.dao.AccountDAO.findAccounts(..) )",returning = "resultY")
	public void afterreturningFindAccountsAdvice(JoinPoint joinPoint,List<Account> resultY) {
		
		String methodString =joinPoint.getSignature().toShortString();
		
		System.out.println("\n====>>> Executing @AfterReturning advice on " +methodString);
		
		
		System.out.println("\n====>>> Result is : "+resultY);
		
		System.out.println(" -- ------------------------ --");
		
		System.out.println(" : Post Proccessing of data :");
		
		if(!resultY.isEmpty()) {
			Account tempAccount=resultY.get(0);
			tempAccount.setName("Ram");
		}
		
		System.out.println("\n====>>>Modified result is : "+resultY);
		
		System.out.println(" -- ------------------------ --");
		
		System.out.println(" : Convert the names to upddercase :");
		
		convertAccountNamestoUppercase(resultY);
		
		System.out.println("\n====>>>Modified result is : "+resultY);
		
	}


	private void convertAccountNamestoUppercase(List<Account> resultY) {
		
		for(Account theAccount:resultY) {
			String theUssernameString=theAccount.getName().toUpperCase();
			
			theAccount.setName(theUssernameString);
		}
		
	}

}




































