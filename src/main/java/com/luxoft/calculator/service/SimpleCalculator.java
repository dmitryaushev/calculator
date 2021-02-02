package com.luxoft.calculator.service;

import com.luxoft.calculator.model.CalculationModel;

public interface SimpleCalculator {

	double addition(CalculationModel operation);

	double subtraction(CalculationModel operation);

	double multiplication(CalculationModel operation);

	double division(CalculationModel operation);
	
	double calculate(CalculationModel operation);
}
