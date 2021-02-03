package com.luxoft.calculator.service.impl;

import com.luxoft.calculator.service.SimpleCalculator;

public class SimpleCalculatorImpl implements SimpleCalculator {

	@Override
	public double addition(Double firstOperand, Double secondOperand) {
		return firstOperand + secondOperand;
	}

	@Override
	public double subtraction(Double firstOperand, Double secondOperand) {
		return firstOperand - secondOperand;
	}

	@Override
	public double multiplication(Double firstOperand, Double secondOperand) {
		return firstOperand * secondOperand;
	}

	@Override
	public double division(Double firstOperand, Double secondOperand) {
		return firstOperand / secondOperand;
	}

	@Override
	public double calculate(Double firstOperand, Double secondOperand, String operationSymbol) {
		double result = 0;
		switch (operationSymbol) {
		case "+":
			result = addition(firstOperand, secondOperand);
			break;
		case "-":
			result = subtraction(firstOperand, secondOperand);
			break;
		case "*":
			result = multiplication(firstOperand, secondOperand);
			break;
		case "/":
			result = division(firstOperand, secondOperand);
			break;
		}
		return result;
	}
}
