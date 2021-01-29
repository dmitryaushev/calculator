package com.luxoft.calculator.service.impl;

import com.luxoft.calculator.model.Operation;
import com.luxoft.calculator.service.SimpleCalculator;

public class SimpleCalculatorImpl implements SimpleCalculator {

	@Override
	public double addition(Operation operation) {
		return operation.getFirstOperand() + operation.getSecondOperand();
	}

	@Override
	public double subtraction(Operation operation) {
		return operation.getFirstOperand() - operation.getSecondOperand();
	}

	@Override
	public double multiplication(Operation operation) {
		return operation.getFirstOperand() * operation.getSecondOperand();
	}

	@Override
	public double division(Operation operation) {
		return operation.getFirstOperand() / operation.getSecondOperand();
	}

	@Override
	public double calculate(Operation operation) {
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
