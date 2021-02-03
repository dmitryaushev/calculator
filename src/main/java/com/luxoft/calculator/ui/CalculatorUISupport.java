package com.luxoft.calculator.ui;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;

import com.luxoft.calculator.exception.InvalidInputException;
import com.luxoft.calculator.model.ModelManager;
import com.luxoft.calculator.service.ValidationService;

public class CalculatorUISupport {

	private CalculatorUI calculatorUI;
	private ModelManager modelManager;

	public CalculatorUISupport(CalculatorUI calculatorUI) {
		this.calculatorUI = calculatorUI;
		this.modelManager = ModelManager.getInstance();
	}

	public void createCalculatorListeners() {
		
		Text firstOperand  = calculatorUI.getFirstOperand();
		Text secondOperand = calculatorUI.getSecondOperand();
		Text resultText = calculatorUI.getResultText();
		Combo operations = calculatorUI.getOperations();
		Button checkBox = calculatorUI.getCheckBox();
		Button calculateButton = calculatorUI.getCalculateButton();

		calculateButton.addSelectionListener(widgetSelectedAdapter(event -> {
			event(firstOperand, secondOperand, operations, resultText);
		}));

		checkBox.addSelectionListener(widgetSelectedAdapter(event -> {
			if (checkBox.getSelection()) {
				calculateButton.setEnabled(false);
				if (!firstOperand.getText().isEmpty() && !secondOperand.getText().isEmpty()) {
					event(firstOperand, secondOperand, operations, resultText);
				}
			} else {
				calculateButton.setEnabled(true);
				resultText.setText("");
			}
		}));

		firstOperand.addListener(SWT.KeyUp, event -> {
			if (checkBox.getSelection()) {
				if (!secondOperand.getText().isEmpty()) {
					event(firstOperand, secondOperand, operations, resultText);
				}
			}
		});

		secondOperand.addListener(SWT.KeyUp, event -> {
			if (checkBox.getSelection()) {
				if (!firstOperand.getText().isEmpty()) {
					event(firstOperand, secondOperand, operations, resultText);
				}
			}
		});

		operations.addListener(SWT.Selection, event -> {
			if (checkBox.getSelection()) {
				event(firstOperand, secondOperand, operations, resultText);
			}
		});
	}
	
	private void event(Text firstOperand, Text secondOperand, Combo operations, Text resultText) {
		
		try {
			String firstOperandString = firstOperand.getText();
			String secondOperandString = secondOperand.getText();
			String operationSymbolString = operations.getText();
			
			ValidationService.validateOperands(firstOperandString, secondOperandString);
			
			Map<String, String> parameters = mapParameters(firstOperandString, secondOperandString, operationSymbolString);
			modelManager.updateModelFromUI(parameters);
			
		} catch (InvalidInputException e) {
			resultText.setText(String.valueOf(e.getMessage()));
		}
	}

	private Map<String, String> mapParameters(String firstOperand, String secondOperand, String operationSymbol) {
		Map<String, String> parameters = new HashMap<>();
		parameters.put("firstOperand", firstOperand);
		parameters.put("secondOperand", secondOperand);
		parameters.put("operationSymbol", operationSymbol);
		return parameters;
	}

}
