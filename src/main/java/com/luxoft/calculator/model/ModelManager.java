package com.luxoft.calculator.model;

import java.util.Map;

import com.luxoft.calculator.service.CalculationService;
import com.luxoft.calculator.service.impl.SimpleCalculatorImpl;

public class ModelManager {
	
	public static ModelManager modelManager;
	
	private CalculationModel calculationModel;
	private CalculationService calculationService;
	
	public void createModel() {
		calculationService = new CalculationService(new SimpleCalculatorImpl());
		calculationModel = new CalculationModel();
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
	
	public void updateModelFromUI(Map<String, String> parameters) {
		calculationModel.setParameters(parameters);
	}
}
