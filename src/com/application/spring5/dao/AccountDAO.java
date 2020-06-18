package com.application.spring5.dao;

import org.springframework.stereotype.Component;

import com.application.spring5.Account;

@Component
public class AccountDAO {

	
	//public void addAccount() {
		//	System.out.println(getClass()+":DOING DB WORK :ADDING AN ACCOUNT");
		//}
		
		public void addAccount(Account theAccount,boolean vipFlag) {
			System.out.println(getClass()+":DOING DB WORK :ADDING AN ACCOUNT");
		}
		
		public boolean addMember() {
			System.out.println(getClass()+":* Point cut test");
			return true;
		}
		
		public boolean doWork() {
			System.out.println(getClass()+":Doing work");
			return true;
		}
}
