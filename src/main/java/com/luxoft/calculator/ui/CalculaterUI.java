package com.luxoft.calculator.ui;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.luxoft.calculator.service.Calculator;
import com.luxoft.calculator.service.HistoryService;

public class CalculaterUI {
	
	private Composite compositeCalculator;
	private CTabItem calculateTab;
	
	private Text firstOperand;
	private Text secondOperand;
	private Text resultText;
	private Combo operations;
	private Button checkBox;
	private Button calculateButton;
	private Label resultLabel;
	
	private GridData operandsData;
	private GridData checkBoxData;
	private GridData calculateButtonData;
	private GridData resultTextData;
	private GridData resultLabelData;
	
	private HistoryService historyService;
	
	public CalculaterUI(HistoryService historyService) {
		this.historyService = historyService;
	};
	
	public void createCalculaterUI(CTabFolder parent) {
		
		compositeCalculator = new Composite(parent, SWT.NONE);
		compositeCalculator.setLayout(new GridLayout(3, false));
		calculateTab = new CTabItem(parent, SWT.NONE);
		calculateTab.setText("calculator");
		calculateTab.setControl(compositeCalculator);
		
		operandsData = new GridData(GridData.FILL_BOTH);

		firstOperand = new Text(compositeCalculator, SWT.BORDER);
		firstOperand.setLayoutData(operandsData);

		operations = new Combo(compositeCalculator, SWT.DROP_DOWN);
		operations.setItems(new String[] { "+", "-", "*", "/" });
		operations.select(0);
		operations.setLayoutData(operandsData);

		secondOperand = new Text(compositeCalculator, SWT.BORDER);
		secondOperand.setLayoutData(operandsData);

		checkBoxData = new GridData(GridData.FILL_BOTH);
		checkBoxData.horizontalSpan = 2;
		checkBoxData.verticalIndent = 100;

		checkBox = new Button(compositeCalculator, SWT.CHECK);
		checkBox.setText("calculate on the fly");
		checkBox.setLayoutData(checkBoxData);

		calculateButton = new Button(compositeCalculator, SWT.PUSH);
		calculateButton.setText("calculate");
		calculateButtonData = new GridData(GridData.FILL_BOTH);
		calculateButtonData.verticalIndent = 100;
		calculateButton.setLayoutData(calculateButtonData);

		resultLabel = new Label(compositeCalculator, SWT.NONE);
		resultLabel.setText("result:");
		resultLabelData = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
		resultLabelData.verticalIndent = 20;
		resultLabel.setLayoutData(resultLabelData);
		
		resultText = new Text(compositeCalculator, SWT.BORDER);
		resultText.setEditable(false);
		resultTextData = new GridData(GridData.FILL_BOTH);
		resultTextData.horizontalSpan = 2;
		resultTextData.verticalIndent = 20;
		resultTextData.horizontalIndent = -35;
		resultText.setLayoutData(resultTextData);
	}
	
	public void createCalculatorEvents() {
		
		calculateButton.addSelectionListener(widgetSelectedAdapter(event -> {
			String result = Calculator.calculate(firstOperand, secondOperand, operations);
			resultText.setText(result);
			historyService.saveHistory(result);
		}));
		
		checkBox.addSelectionListener(widgetSelectedAdapter(event -> {
			if (checkBox.getSelection()) {
				calculateButton.setEnabled(false);
				if (!firstOperand.getText().isEmpty() && !secondOperand.getText().isEmpty()) {
					String result = Calculator.calculate(firstOperand, secondOperand, operations);
					resultText.setText(result);
					historyService.saveHistory(result);
				}
			} else {
				calculateButton.setEnabled(true);
				resultText.setText("");
			}
		}));

		firstOperand.addListener(SWT.KeyUp, event -> {
			if (checkBox.getSelection()) {
				if (!secondOperand.getText().isEmpty()) {
					String result = Calculator.calculate(firstOperand, secondOperand, operations);
					resultText.setText(result);
					historyService.saveHistory(result);
				}
			}
		});
		
		secondOperand.addListener(SWT.KeyUp, event -> {
			if (checkBox.getSelection()) {
				if (!firstOperand.getText().isEmpty()) {
					String result = Calculator.calculate(firstOperand, secondOperand, operations);
					resultText.setText(result);
					historyService.saveHistory(result);
				}
			}
		});
		
		operations.addListener(SWT.Selection, event -> {
			if (checkBox.getSelection()) {
				String result = Calculator.calculate(firstOperand, secondOperand, operations);
				resultText.setText(result);
				historyService.saveHistory(result);
			}
		});
	}
}
