package com.luxoft.calculator.ui;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;

import com.luxoft.calculator.model.CalculationModel;
import com.luxoft.calculator.model.ModelManager;
import com.luxoft.calculator.service.HistoryService;
import com.luxoft.calculator.service.SimpleCalculator;

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
			if (validateOperands(firstOperand, secondOperand)) {
				resultText.setText(String.valueOf("invalid input"));
				return;
			}
			Map<String, String> parameters = mapParameters(firstOperand, secondOperand, operations);
			calculationModel.setParameters(parameters);
		}));

		checkBox.addSelectionListener(widgetSelectedAdapter(event -> {
			if (checkBox.getSelection()) {
				calculateButton.setEnabled(false);
				if (!firstOperand.getText().isEmpty() && !secondOperand.getText().isEmpty()) {
					if (validateOperands(firstOperand, secondOperand)) {
						resultText.setText(String.valueOf("invalid input"));
						return;
					}
					Map<String, String> parameters = mapParameters(firstOperand, secondOperand, operations);
					calculationModel.setParameters(parameters);
				}
			} else {
				calculateButton.setEnabled(true);
				resultText.setText("");
			}
		}));

		firstOperand.addListener(SWT.KeyUp, event -> {
			if (checkBox.getSelection()) {
				if (!secondOperand.getText().isEmpty()) {
					if (validateOperands(firstOperand, secondOperand)) {
						resultText.setText(String.valueOf("invalid input"));
						return;
					}
					Map<String, String> parameters = mapParameters(firstOperand, secondOperand, operations);
					calculationModel.setParameters(parameters);
				}
			}
		});

		secondOperand.addListener(SWT.KeyUp, event -> {
			if (checkBox.getSelection()) {
				if (!firstOperand.getText().isEmpty()) {
					if (validateOperands(firstOperand, secondOperand)) {
						resultText.setText(String.valueOf("invalid input"));
						return;
					}
					Map<String, String> parameters = mapParameters(firstOperand, secondOperand, operations);
					calculationModel.setParameters(parameters);
				}
			}
		});

		operations.addListener(SWT.Selection, event -> {
			if (checkBox.getSelection()) {
				if (validateOperands(firstOperand, secondOperand)) {
					resultText.setText(String.valueOf("invalid input"));
					return;
				}
				Map<String, String> parameters = mapParameters(firstOperand, secondOperand, operations);
				calculationModel.setParameters(parameters);
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
	
	private boolean validateOperands(Text firstOperandText, Text secondOperandText) {
		return !firstOperandText.getText().matches("[0-9]+") || !secondOperandText.getText().matches("[0-9]+");
	}
}
