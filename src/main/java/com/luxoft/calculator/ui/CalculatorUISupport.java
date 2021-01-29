package com.luxoft.calculator.ui;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;

import com.luxoft.calculator.model.Operation;
import com.luxoft.calculator.service.HistoryService;
import com.luxoft.calculator.service.SimpleCalculator;

public class CalculatorUISupport {

	private CalculatorUI calculatorUI;
	private HistoryService historyService;
	private SimpleCalculator simpleCalculator;

	public CalculatorUISupport(CalculatorUI calculatorUI, HistoryService historyService,
			SimpleCalculator simpleCalculator) {
		this.calculatorUI = calculatorUI;
		this.historyService = historyService;
		this.simpleCalculator = simpleCalculator;
	}

	public void createCalculatorListeners() {
		
		Text firstOperand  = calculatorUI.getFirstOperand();
		Text secondOperand = calculatorUI.getSecondOperand();
		Text resultText = calculatorUI.getResultText();
		Combo operations = calculatorUI.getOperations();
		Button checkBox = calculatorUI.getCheckBox();
		Button calculateButton = calculatorUI.getCalculateButton();

		calculateButton.addSelectionListener(widgetSelectedAdapter(event -> {
			double result = simpleCalculator.calculate(mapOperation(firstOperand, secondOperand, operations));
			resultText.setText(String.valueOf(result));
			historyService.saveHistory(String.valueOf(result));
		}));

		checkBox.addSelectionListener(widgetSelectedAdapter(event -> {
			if (checkBox.getSelection()) {
				calculateButton.setEnabled(false);
				if (!firstOperand.getText().isEmpty() && !secondOperand.getText().isEmpty()) {
					double result = simpleCalculator.calculate(mapOperation(firstOperand, secondOperand, operations));
					resultText.setText(String.valueOf(result));
					historyService.saveHistory(String.valueOf(result));
				}
			} else {
				calculateButton.setEnabled(true);
				resultText.setText("");
			}
		}));

		firstOperand.addListener(SWT.KeyUp, event -> {
			if (checkBox.getSelection()) {
				if (!secondOperand.getText().isEmpty()) {
					double result = simpleCalculator.calculate(mapOperation(firstOperand, secondOperand, operations));
					resultText.setText(String.valueOf(result));
					historyService.saveHistory(String.valueOf(result));
				}
			}
		});

		secondOperand.addListener(SWT.KeyUp, event -> {
			if (checkBox.getSelection()) {
				if (!firstOperand.getText().isEmpty()) {
					double result = simpleCalculator.calculate(mapOperation(firstOperand, secondOperand, operations));
					resultText.setText(String.valueOf(result));
					historyService.saveHistory(String.valueOf(result));
				}
			}
		});

		operations.addListener(SWT.Selection, event -> {
			if (checkBox.getSelection()) {
				double result = simpleCalculator.calculate(mapOperation(firstOperand, secondOperand, operations));
				resultText.setText(String.valueOf(result));
				historyService.saveHistory(String.valueOf(result));
			}
		});
	}

	private Operation mapOperation(Text firstOperandText, Text secondOperandText, Combo operations) {

		double firstOperand = Double.valueOf(firstOperandText.getText());
		double secondOperand = Double.valueOf(secondOperandText.getText());
		String operationSymbol = operations.getText();

		return new Operation(firstOperand, secondOperand, operationSymbol);
	}
}
