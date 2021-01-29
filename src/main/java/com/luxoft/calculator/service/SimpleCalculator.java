package com.luxoft.calculator.service;

import com.luxoft.calculator.model.OperationModel;

public interface SimpleCalculator {

	double addition(OperationModel operation);

	double subtraction(OperationModel operation);

	double multiplication(OperationModel operation);

	double division(OperationModel operation);
	
	double calculate(OperationModel operation);
}
