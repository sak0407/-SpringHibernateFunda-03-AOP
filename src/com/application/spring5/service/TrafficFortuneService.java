package com.application.spring5.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;


@Component("fortuneService")
public class TrafficFortuneService {
	
	public String getFortune() {
		
		//simulate/create a delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		//return a fortune
		
		return "Expect heavy traffic this morning";
	}

	public String getFortuneException(boolean tripWire) {

		if(tripWire) {
			throw new RuntimeException("Major accident ! Highway closed");
		}
		return getFortune();
	}

	public String getFortuneExceptionRethrow(boolean tripWire1) {
		if(tripWire1) {
			throw new RuntimeException("Major accident ! Highway closed");
		}
		return getFortune();
	}

}
