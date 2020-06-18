package com.application.spring5;

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
		theAccountDAO.addAccount(myAccount,true);
		
		theMemberShipDAO.addAccount();
		theAccountDAO.addMember();
		theAccountDAO.doWork();
		theMemberShipDAO.goToSleep();
		
		
		
		
		//close the context
		context.close();
	}

}
