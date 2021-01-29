package com.luxoft.calculator.service;

import com.luxoft.calculator.model.Operation;

public interface SimpleCalculator {

	double addition(Operation operation);

	double subtraction(Operation operation);

	double multiplication(Operation operation);

	double division(Operation operation);
	
	double calculate(Operation operation);
}
