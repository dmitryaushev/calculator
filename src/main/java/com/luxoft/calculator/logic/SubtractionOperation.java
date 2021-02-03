package com.luxoft.calculator.logic;

import com.luxoft.calculator.interfaces.MathOperation;

public class SubtractionOperation implements MathOperation {

	@Override
	public double calculationResult(Double firstOperand, Double secondOperand) {
		return firstOperand - secondOperand;
	}

}
