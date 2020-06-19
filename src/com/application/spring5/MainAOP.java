package com.application.spring5;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.application.spring5.dao.AccountDAO;
import com.application.spring5.dao.MemberShipDAO;
import com.application.spring5.service.TrafficFortuneService;

public class MainAOP {
	
	private static Logger myLogger =
			Logger.getLogger(MainAOP.class.getName());
	
	public static void main(String[] args) {
		
		//read spring config java class
		
		
		
		AnnotationConfigApplicationContext context
		  = new AnnotationConfigApplicationContext(Config.class);
		
		
		//get the bean from spring container
		AccountDAO theAccountDAO=context.getBean("accountDAO",AccountDAO.class);
		MemberShipDAO theMemberShipDAO=context.getBean("memberDAO",MemberShipDAO.class);
		//used in @Around advice
		TrafficFortuneService theFortuneService=context.getBean("fortuneService",TrafficFortuneService.class);
		
		System.out.println("----------------------------------------------------");
		System.out.println("-------------Before Advice------------------");
		System.out.println("----------------------------------------------------");
		
		//call the business method
		//theAccountDAO.addAccount();
		Account myAccount=new Account();
		myAccount.setName("Wells");
		myAccount.setLevel("Fargo");
		theAccountDAO.addAccount(myAccount,true);
		
		theMemberShipDAO.addAccount();
		theAccountDAO.addMember();
		theAccountDAO.doWork();
		theMemberShipDAO.goToSleep();
		
		
		//call the getter /setter methods		
		theAccountDAO.setName("Selim");
		theAccountDAO.setService("Silver");
		theAccountDAO.getName();
		theAccountDAO.getService();
		
		System.out.println("----------------------------------------------------");
		System.out.println("-------------After Returning Advice-----------------");
		System.out.println("----------------------------------------------------");
		//After returning advice main method execution 
		
		List<Account> theAccounts=theAccountDAO.findAccounts();
		
		myLogger.info("From main => "+theAccounts);
		myLogger.info("\n");
		
		System.out.println("----------------------------------------------------");
		System.out.println("-------------After Throwing Advice-----------------");
		System.out.println("----------------------------------------------------");
		 
		List<Account> theAccounts1= null;
		try {
			//add a boolean flag to simulate exceptions 
			boolean tripWire = true;
			
			theAccounts1=theAccountDAO.findAccountsWithException(tripWire);
		}catch (Exception e) {
			myLogger.info(" -- > Main programm ..caught exception "+e);
		}
		
		myLogger.info("From main => "+theAccounts1);
		myLogger.info("\n");
		

		
		System.out.println("----------------------------------------------------");
		System.out.println("-------------After(Finally)Advice-----------------");
		System.out.println("----------------------------------------------------");
		
		List<Account> theAccounts2= null;
		try {
			//add a boolean flag to simulate exceptions 
			//boolean tripWire = true; //Failure case
			boolean tripWire = false;  //Success case
			
			theAccounts2=theAccountDAO.findAccountsWithAfter(tripWire);
		}catch (Exception e) {
			myLogger.info(" -- > Main programm ..caught exception "+e);
		}
		
		myLogger.info("From main => "+theAccounts2);
		myLogger.info("\n");
		System.out.println("----------------------------------------------------");
		System.out.println("-------------Around Advice-----------------");
		System.out.println("----------------------------------------------------");
		
		
		myLogger.info("Get fortune execution Started ");
		String dataString = theFortuneService.getFortune();
		
		myLogger.info("\n");
		myLogger.info("From main  :: My Fortune is => "+dataString);
		myLogger.info("\n");
		
		
		System.out.println("----------------------------------------------------");
		System.out.println("-------------Around Advice Handling Exception-----------------");
		System.out.println("----------------------------------------------------");
		
		boolean tripWire = true;
		myLogger.info("Get fortune execution Started ");
		String dataString1 = theFortuneService.getFortuneException(tripWire);
		
		myLogger.info("\n");
		myLogger.info("From main  :: My Fortune is => "+dataString1);
		myLogger.info("\n");

		
		System.out.println("----------------------------------------------------");
		System.out.println("-------------Around Advice Exception Rethrow-----------------");
		System.out.println("----------------------------------------------------");
		
		myLogger.info("Get fortune execution Started ");
		
		boolean tripWire1 = true;	
		String dataString2= null;
		try {
			dataString2= theFortuneService.getFortuneExceptionRethrow(tripWire1);
		} catch (Exception e) {
			System.out.println("Exception Handled from Main method");
		}
		
		
		myLogger.info("\n");
		myLogger.info("From main  :: My Fortune is => "+dataString2);
		myLogger.info("\n");
		
		System.out.println("----------------------------------------------------");
		System.out.println("----------------------------------------------------");
		//close the context
		context.close();
	}

}


























