package com.luxoft.calculator.logic;

import java.util.HashMap;
import java.util.Map;

import com.luxoft.calculator.interfaces.MathOperation;

public abstract class AbstractCalculator {
	
	protected Map<String, MathOperation> mathOperationMap;

	public abstract double makeCalculation(Double firstOperand, Double secondOperand, String operationSymbol);
	
	protected void initOperationMap() {
		mathOperationMap = new HashMap<String, MathOperation>();
		mathOperationMap.put(MathOperation.ADDITION, new AdditionOperation());
		mathOperationMap.put(MathOperation.SUBSTRACTION, new SubtractionOperation());
		mathOperationMap.put(MathOperation.MULTIPLICATION, new MultiplicationOperation());
		mathOperationMap.put(MathOperation.DIVISION, new DivisionOperation());
	}
}
