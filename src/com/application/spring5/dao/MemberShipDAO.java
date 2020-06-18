package com.application.spring5.dao;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException.Gone;

@Component("memberDAO")
public class MemberShipDAO {

	
	public void addAccount() {
		System.out.println(getClass()+":DOING DB WORK :ADDING AN ACCOUNT from Membership DAO");
	}
	
	public void goToSleep() {
		System.out.println(getClass()+" Going to sleep");
	}
}
