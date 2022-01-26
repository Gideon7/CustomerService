package com.customerservice.application.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class NumberGenerator {
	
	public String generateAccountNumber() {
		String rand = RandomStringUtils.randomNumeric(10);
		return rand;
	}
}
