package com.luxoft.calculator.service.impl;

import com.luxoft.calculator.model.OperationModel;
import com.luxoft.calculator.service.SimpleCalculator;

public class SimpleCalculatorImpl implements SimpleCalculator {

	@Override
	public double addition(OperationModel operation) {
		return operation.getFirstOperand() + operation.getSecondOperand();
	}

	@Override
	public double subtraction(OperationModel operation) {
		return operation.getFirstOperand() - operation.getSecondOperand();
	}

	@Override
	public double multiplication(OperationModel operation) {
		return operation.getFirstOperand() * operation.getSecondOperand();
	}

	@Override
	public double division(OperationModel operation) {
		return operation.getFirstOperand() / operation.getSecondOperand();
	}

	@Override
	public double calculate(OperationModel operation) {
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
