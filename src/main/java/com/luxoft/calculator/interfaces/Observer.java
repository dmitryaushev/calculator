package com.luxoft.calculator.interfaces;

public interface Observer {
	void update(Double firstOperand, Double secondOperand, String operationSymbol);
}
