package com.application.spring5.dao;

import org.springframework.stereotype.Component;

@Component("memberDAO")
public class MemberShipDAO {

	
	public void addAccount() {
		System.out.println(getClass()+":DOING DB WORK :ADDING AN ACCOUNT from Membership DAO");
	}
}
