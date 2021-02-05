package com.luxoft.calculator.ui;

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

public class CalculatorUI {

	private Composite compositeCalculator;
	private CTabItem calculateTab;

	private Text firstOperand;
	private Text secondOperand;
	private Text resultText;
	private Combo operations;
	private Button checkBox;
	private Button calculateButton;
	private Label resultLabel;
	
	public CalculatorUI(CTabFolder parent) {
		createCalculatorUI(parent);
	}

	public Text getFirstOperand() {
		return firstOperand;
	}

	public Text getSecondOperand() {
		return secondOperand;
	}

	public Text getResultText() {
		return resultText;
	}

	public Combo getOperations() {
		return operations;
	}

	public Button getCheckBox() {
		return checkBox;
	}

	public Button getCalculateButton() {
		return calculateButton;
	}

	private void createCalculatorUI(CTabFolder parent) {

		compositeCalculator = new Composite(parent, SWT.NONE);
		compositeCalculator.setLayout(new GridLayout(3, false));
		calculateTab = new CTabItem(parent, SWT.NONE);
		calculateTab.setText("calculator");
		calculateTab.setControl(compositeCalculator);

		GridData operandsData = new GridData(GridData.FILL_HORIZONTAL);

		firstOperand = new Text(compositeCalculator, SWT.BORDER);
		firstOperand.setLayoutData(operandsData);

		operations = new Combo(compositeCalculator, SWT.DROP_DOWN);
		operations.setItems(new String[] { "+", "-", "*", "/" });
		operations.select(0);
		operations.setLayoutData(operandsData);

		secondOperand = new Text(compositeCalculator, SWT.BORDER);
		secondOperand.setLayoutData(operandsData);

		GridData checkBoxData = new GridData(GridData.FILL_BOTH);
		checkBoxData.horizontalSpan = 2;
		checkBoxData.verticalIndent = 100;

		checkBox = new Button(compositeCalculator, SWT.CHECK);
		checkBox.setText("calculate on the fly");
		checkBox.setLayoutData(checkBoxData);

		calculateButton = new Button(compositeCalculator, SWT.PUSH);
		calculateButton.setText("calculate");
		GridData calculateButtonData = new GridData(GridData.FILL_BOTH);
		calculateButtonData.verticalIndent = 100;
		calculateButton.setLayoutData(calculateButtonData);

		resultLabel = new Label(compositeCalculator, SWT.NONE);
		resultLabel.setText("result:");
		GridData resultLabelData = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
		resultLabelData.verticalIndent = 20;
		resultLabel.setLayoutData(resultLabelData);

		resultText = new Text(compositeCalculator, SWT.BORDER);
		resultText.setEditable(false);
		GridData resultTextData = new GridData(GridData.FILL_BOTH);
		resultTextData.horizontalSpan = 2;
		resultTextData.verticalIndent = 20;
		resultTextData.horizontalIndent = -35;
		resultText.setLayoutData(resultTextData);
	}
}
