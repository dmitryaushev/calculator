package com.luxoft.calculator.service;

import com.luxoft.calculator.exception.InvalidInputException;

public class ValidationService {
	
	public static void validateOperands(String firstOperand, String secondOperand) {
		String regexp = "^-?[0-9]\\d*(\\.\\d+)?$";
		if (!firstOperand.matches(regexp) || !secondOperand.matches(regexp)) {
			throw new InvalidInputException("invalid input");
		}
	}
}
