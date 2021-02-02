package com.luxoft.calculator.model;

import com.luxoft.calculator.service.CalculationService;
import com.luxoft.calculator.service.impl.SimpleCalculatorImpl;

public class ModelManager {
	
	public static ModelManager modelManager;
	
	private CalculationModel calculationModel;
	private CalculationService calculationService;
	
	public void createModel() {
		calculationModel = new CalculationModel();
		calculationService = new CalculationService(new SimpleCalculatorImpl());
		calculationModel.addObserver(calculationService);
	}
	
	public static ModelManager getInstance() {
		if (modelManager == null) {
			modelManager = new ModelManager();
		}
		return modelManager;
	}

	public CalculationModel getCalculationModel() {
		return calculationModel;
	}
}
