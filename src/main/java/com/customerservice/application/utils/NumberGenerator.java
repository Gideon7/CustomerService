package com.customerservice.application.utils;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class NumberGenerator {
	
	public long generateAccountNumber() {
		Random random = new Random();
		return random.nextLong();
	}
}
