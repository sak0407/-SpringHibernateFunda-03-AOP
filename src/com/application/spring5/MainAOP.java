package com.application.spring5;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.application.spring5.dao.AccountDAO;
import com.application.spring5.dao.MemberShipDAO;

public class MainAOP {
	
	public static void main(String[] args) {
		
		//read spring config java class
		
		AnnotationConfigApplicationContext context
		  = new AnnotationConfigApplicationContext(Config.class);
		
		
		//get the bean from spring container
				AccountDAO theAccountDAO=context.getBean("accountDAO",AccountDAO.class);
				MemberShipDAO theMemberShipDAO=context.getBean("memberDAO",MemberShipDAO.class);
				
		
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
		
		System.out.println("From main => "+theAccounts);
		System.out.println("\n");
		
		System.out.println("----------------------------------------------------");
		System.out.println("----------------------------------------------------");
		
		//close the context
		context.close();
	}

}


























