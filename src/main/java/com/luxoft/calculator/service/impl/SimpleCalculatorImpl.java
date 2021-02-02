package com.luxoft.calculator.service.impl;

import com.luxoft.calculator.model.CalculationModel;
import com.luxoft.calculator.service.SimpleCalculator;

public class SimpleCalculatorImpl implements SimpleCalculator {

	@Override
	public double addition(CalculationModel operation) {
		return operation.getFirstOperand() + operation.getSecondOperand();
	}

	@Override
	public double subtraction(CalculationModel operation) {
		return operation.getFirstOperand() - operation.getSecondOperand();
	}

	@Override
	public double multiplication(CalculationModel operation) {
		return operation.getFirstOperand() * operation.getSecondOperand();
	}

	@Override
	public double division(CalculationModel operation) {
		return operation.getFirstOperand() / operation.getSecondOperand();
	}

	@Override
	public double calculate(CalculationModel operation) {
		double result = 0;
		switch (operation.getOperationSymbol()) {
		case "+":
			result = addition(operation);
			break;
		case "-":
			result = subtraction(operation);
			break;
		case "*":
			result = multiplication(operation);
			break;
		case "/":
			result = division(operation);
			break;
		}
		return result;
	}
}
