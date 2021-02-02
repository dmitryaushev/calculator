package com.luxoft.calculator.service;

import com.luxoft.calculator.model.CalculationModel;
import com.luxoft.calculator.model.ModelManager;
import com.luxoft.calculator.ui.ViewManager;

public class CalculationService implements Observer{

	private SimpleCalculator simpleCalculator;
	private CalculationModel calculationModel;
	private ViewManager viewManager;
	
	public CalculationService(SimpleCalculator simpleCalculator) {
		this.simpleCalculator = simpleCalculator;
		this.calculationModel = ModelManager.getInstance().getCalculationModel();
		this.viewManager = ViewManager.getInstance();
	}

	@Override
	public void update(Double firstOperand, Double secondOperand, String operationSymbol) {
		this.calculationModel.setFirstOperand(firstOperand);
		this.calculationModel.setSecondOperand(secondOperand);
		this.calculationModel.setOperationSymbol(operationSymbol);
		calculation(calculationModel);
	}
	
	private void calculation(CalculationModel calculationModel) {
		String result = String.valueOf(simpleCalculator.calculate(calculationModel));
		viewManager.getCalculateUI().getResultText().setText(result);
		saveHistory(result);
	}
	
	private void saveHistory(String result) {
		viewManager.getHistoryUI().getHistory().add(result);
	}
}
