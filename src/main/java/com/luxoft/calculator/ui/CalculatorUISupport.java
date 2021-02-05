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

	private Text firstOperand;
	private Text secondOperand;
	private Text resultText;
	private Combo operationSymbol;
	private Button checkBox;
	private Button calculateButton;

	public CalculatorUISupport(CalculatorUI calculatorUI) {
		this.calculatorUI = calculatorUI;
		this.modelManager = ModelManager.getInstance();
		createCalculatorListeners();
	}

	private void createCalculatorListeners() {

		firstOperand = calculatorUI.getFirstOperand();
		secondOperand = calculatorUI.getSecondOperand();
		resultText = calculatorUI.getResultText();
		operationSymbol = calculatorUI.getOperations();
		checkBox = calculatorUI.getCheckBox();
		calculateButton = calculatorUI.getCalculateButton();

		calculateButton.addSelectionListener(widgetSelectedAdapter(event -> {
			dataProcessing();
		}));

		checkBox.addSelectionListener(widgetSelectedAdapter(event -> {
			if (checkBox.getSelection()) {
				calculateButton.setEnabled(false);
				if (!firstOperand.getText().isEmpty() && !secondOperand.getText().isEmpty()) {
					dataProcessing();
				}
			} else {
				calculateButton.setEnabled(true);
				resultText.setText("");
			}
		}));

		firstOperand.addListener(SWT.KeyUp, event -> {
			if (checkBox.getSelection()) {
				if (!secondOperand.getText().isEmpty()) {
					dataProcessing();
				}
			}
		});

		secondOperand.addListener(SWT.KeyUp, event -> {
			if (checkBox.getSelection()) {
				if (!firstOperand.getText().isEmpty()) {
					dataProcessing();
				}
			}
		});

		operationSymbol.addListener(SWT.Selection, event -> {
			if (checkBox.getSelection()) {
				dataProcessing();
			}
		});
	}

	private void dataProcessing() {
		try {
			ValidationService.validateOperands(firstOperand.getText(), secondOperand.getText());
			Map<String, String> parameters = mapParameters();
			modelManager.updateModelFromUI(parameters);
		} catch (InvalidInputException e) {
			resultText.setText(String.valueOf(e.getMessage()));
		}
	}

	private Map<String, String> mapParameters() {
		Map<String, String> parameters = new HashMap<>();
		parameters.put("firstOperand", firstOperand.getText());
		parameters.put("secondOperand", secondOperand.getText());
		parameters.put("operationSymbol", operationSymbol.getText());
		return parameters;
	}
}
