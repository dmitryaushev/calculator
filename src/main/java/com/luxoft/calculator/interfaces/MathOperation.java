package com.luxoft.calculator.interfaces;

public interface MathOperation {

	final String ADDITION = "+";
	final String SUBSTRACTION = "-";
	final String MULTIPLICATION = "*";
	final String DIVISION = "/";
	
	double calculateResult(Double firstOperand, Double secondOperand);
}
