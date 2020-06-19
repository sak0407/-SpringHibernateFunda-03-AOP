package com.application.spring5.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.application.spring5.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String service;
	
		
	public String getName() {
		System.out.println("In getName");
		return name;
	}

	public void setName(String name) {
		System.out.println("In setName");
		this.name = name;
	}

	public String getService() {
		System.out.println("In getService");
		return service;
	}

	public void setService(String service) {
		System.out.println("In setService");
		this.service = service;
	}
	
	
	
	
	//public void addAccount() {
			//	System.out.println(getClass()+":DOING DB WORK :ADDING AN ACCOUNT");
			//}

		public void addAccount(Account theAccount,boolean vipFlag) {
			System.out.println(getClass()+":ADDING AN ACCOUNT");
		}
		
		public boolean addMember() {
			System.out.println(getClass()+":* Point cut test");
			return true;
		}
		
		public boolean doWork() {
			System.out.println(getClass()+":Doing work");
			return true;
		}
		
		
		
		public List<Account> findAccounts(){
			
			List<Account> myAccounts = new ArrayList<Account>();
			
			myAccounts.add(new Account("Sam","Gold"));
			myAccounts.add(new Account("Suresh","Bronze"));
			myAccounts.add(new Account("Ramesh","Silver"));
			
			return myAccounts;
		}

		public List<Account> findAccountsWithException(boolean tripWire) {
			
			if(tripWire) {
				throw new RuntimeException("Exception raised from Account DAO");
			}
			
			List<Account> myAccounts = new ArrayList<Account>();
			
			myAccounts.add(new Account("Sam","Gold"));
			myAccounts.add(new Account("Suresh","Bronze"));
			myAccounts.add(new Account("Ramesh","Silver"));
			
			return myAccounts;
		}

		public List<Account> findAccountsWithAfter(boolean tripWire) {
			
			if(tripWire) {
				throw new RuntimeException("Exception raised from Account DAO");
			}
			
			List<Account> myAccounts = new ArrayList<Account>();
			
			myAccounts.add(new Account("Sam","Gold"));
			myAccounts.add(new Account("Suresh","Bronze"));
			myAccounts.add(new Account("Ramesh","Silver"));
			
			return myAccounts;
		}
}





























