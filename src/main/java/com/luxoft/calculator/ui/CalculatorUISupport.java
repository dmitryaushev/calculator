package com.luxoft.calculator.ui;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;

import com.luxoft.calculator.exception.InvalidInputException;
import com.luxoft.calculator.model.CalculationModel;
import com.luxoft.calculator.model.ModelManager;

public class CalculatorUISupport {

	private CalculatorUI calculatorUI;
	private CalculationModel calculationModel;

	public CalculatorUISupport(CalculatorUI calculatorUI) {
		this.calculatorUI = calculatorUI;
		this.calculationModel = ModelManager.getInstance().getCalculationModel();
	}

	public void createCalculatorListeners() {
		
		Text firstOperand  = calculatorUI.getFirstOperand();
		Text secondOperand = calculatorUI.getSecondOperand();
		Text resultText = calculatorUI.getResultText();
		Combo operations = calculatorUI.getOperations();
		Button checkBox = calculatorUI.getCheckBox();
		Button calculateButton = calculatorUI.getCalculateButton();

		calculateButton.addSelectionListener(widgetSelectedAdapter(event -> {
			try {
				validateOperands(firstOperand, secondOperand);					
				Map<String, String> parameters = mapParameters(firstOperand, secondOperand, operations);
				calculationModel.setParameters(parameters);
			} catch (InvalidInputException e) {
				resultText.setText(String.valueOf(e.getMessage()));
			}
		}));

		checkBox.addSelectionListener(widgetSelectedAdapter(event -> {
			if (checkBox.getSelection()) {
				calculateButton.setEnabled(false);
				if (!firstOperand.getText().isEmpty() && !secondOperand.getText().isEmpty()) {
					try {
						validateOperands(firstOperand, secondOperand);					
						Map<String, String> parameters = mapParameters(firstOperand, secondOperand, operations);
						calculationModel.setParameters(parameters);
					} catch (InvalidInputException e) {
						resultText.setText(String.valueOf(e.getMessage()));
					}
				}
			} else {
				calculateButton.setEnabled(true);
				resultText.setText("");
			}
		}));

		firstOperand.addListener(SWT.KeyUp, event -> {
			if (checkBox.getSelection()) {
				if (!secondOperand.getText().isEmpty()) {
					try {
						validateOperands(firstOperand, secondOperand);					
						Map<String, String> parameters = mapParameters(firstOperand, secondOperand, operations);
						calculationModel.setParameters(parameters);
					} catch (InvalidInputException e) {
						resultText.setText(String.valueOf(e.getMessage()));
					}
				}
			}
		});

		secondOperand.addListener(SWT.KeyUp, event -> {
			if (checkBox.getSelection()) {
				if (!firstOperand.getText().isEmpty()) {
					try {
						validateOperands(firstOperand, secondOperand);					
						Map<String, String> parameters = mapParameters(firstOperand, secondOperand, operations);
						calculationModel.setParameters(parameters);
					} catch (InvalidInputException e) {
						resultText.setText(String.valueOf(e.getMessage()));
					}
				}
			}
		});

		operations.addListener(SWT.Selection, event -> {
			if (checkBox.getSelection()) {
				try {
					validateOperands(firstOperand, secondOperand);					
					Map<String, String> parameters = mapParameters(firstOperand, secondOperand, operations);
					calculationModel.setParameters(parameters);
				} catch (InvalidInputException e) {
					resultText.setText(String.valueOf(e.getMessage()));
				}
			}
		});
	}

	private Map<String, String> mapParameters(Text firstOperandText, Text secondOperandText, Combo operations) {
		Map<String, String> parameters = new HashMap<>();
		parameters.put("firstOperand", firstOperandText.getText());
		parameters.put("secondOperand", secondOperandText.getText());
		parameters.put("operationSymbol", operations.getText());
		return parameters;
	}
	
	private void validateOperands(Text firstOperandText, Text secondOperandText) {
		if (!firstOperandText.getText().matches("[0-9]+") || !secondOperandText.getText().matches("[0-9]+")) {
			throw new InvalidInputException("invalid input");
		}
	}
}
