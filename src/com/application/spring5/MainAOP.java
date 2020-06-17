package com.application.spring5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.application.spring5.dao.AccountDAO;


public class MainAOP {
	
	public static void main(String[] args) {
		
		//read spring config java class
		
		AnnotationConfigApplicationContext context
		  = new AnnotationConfigApplicationContext(Config.class);
		
		
		//get the bean from spring container
		AccountDAO theAccountDAO=context.getBean("accountDAO",AccountDAO.class);
		
		
		
		//call the business method
		theAccountDAO.addAccount();
		
		
				
		
		//close the context
		context.close();
	}

}
