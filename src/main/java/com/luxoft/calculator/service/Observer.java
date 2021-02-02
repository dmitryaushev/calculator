package com.luxoft.calculator.service;

public interface Observer {
	void update(Double firstOperand, Double secondOperand, String operationSymbol);
}
