package com.luxoft.calculator.logic;

public class SimpleCalculator extends AbstractCalculator {
	
	public SimpleCalculator() {
		initOperationMap();
	}

	@Override
	public double makeCalculation(Double firstOperand, Double secondOperand, String operationSymbol) {
		return mathOperationMap.get(operationSymbol).calculationResult(firstOperand, secondOperand);
	}

}
