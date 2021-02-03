package com.luxoft.calculator.service;

import com.luxoft.calculator.ui.ViewManager;

public class CalculationService implements Observer{

	private SimpleCalculator simpleCalculator;
	private ViewManager viewManager;
	
	public CalculationService(SimpleCalculator simpleCalculator) {
		this.simpleCalculator = simpleCalculator;
		this.viewManager = ViewManager.getInstance();
	}

	@Override
	public void update(Double firstOperand, Double secondOperand, String operationSymbol) {
		calculation(firstOperand, secondOperand, operationSymbol);
	}
	
	private void calculation(Double firstOperand, Double secondOperand, String operationSymbol) {
		Double resultDouble = simpleCalculator.calculate(firstOperand, secondOperand, operationSymbol);
		String result = String.valueOf(resultDouble);
		viewManager.getCalculateUI().getResultText().setText(result);
		viewManager.getHistoryUI().getHistory().add(result);
	}
}
