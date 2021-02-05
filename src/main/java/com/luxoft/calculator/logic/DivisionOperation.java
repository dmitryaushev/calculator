package com.luxoft.calculator.logic;

import com.luxoft.calculator.interfaces.MathOperation;

public class DivisionOperation implements MathOperation {

	@Override
	public double calculateResult(Double firstOperand, Double secondOperand) {
		return firstOperand / secondOperand;
	}

}
