package com.luxoft.calculator.service;

public interface SimpleCalculator {

	double addition(Double firstOperand, Double secondOperand);

	double subtraction(Double firstOperand, Double secondOperand);

	double multiplication(Double firstOperand, Double secondOperand);

	double division(Double firstOperand, Double secondOperand);
	
	double calculate(Double firstOperand, Double secondOperand, String operationSymbol);
}
