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

public class CalculateUI {
	
	private Composite compositeCalculator;
	private CTabItem calculateTab;
	
	private Text firstOperand;
	private Text secondOperand;
	private Text resultText;
	private Combo combo;
	private Button checkBox;
	private Button calculateButton;
	private Label resultLabel;
	
	private GridData checkBoxData;
	private GridData operandsData;
	
	public void createCalculateUI(CTabFolder parent) {
		
		compositeCalculator = new Composite(parent, SWT.NONE);
		compositeCalculator.setLayout(new GridLayout(3, false));
		calculateTab = new CTabItem(parent, SWT.NONE);
		calculateTab.setText("calculator");
		calculateTab.setControl(compositeCalculator);
		
		operandsData = new GridData(GridData.VERTICAL_ALIGN_FILL);

		firstOperand = new Text(compositeCalculator, SWT.BORDER);
		firstOperand.setLayoutData(operandsData);

		combo = new Combo(compositeCalculator, SWT.DROP_DOWN);
		combo.setItems(new String[] { "+", "-", "*", "/" });
		combo.select(0);
		combo.setLayoutData(operandsData);

		secondOperand = new Text(compositeCalculator, SWT.BORDER);
		secondOperand.setLayoutData(operandsData);

		checkBoxData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		checkBoxData.horizontalSpan = 2;

		checkBox = new Button(compositeCalculator, SWT.CHECK);
		checkBox.setText("calculate on the fly");
		checkBox.setLayoutData(checkBoxData);

		calculateButton = new Button(compositeCalculator, SWT.PUSH);
		calculateButton.setText("calculate");
		calculateButton.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

		resultLabel = new Label(compositeCalculator, SWT.NONE);
		resultLabel.setText("result:");
		resultText = new Text(compositeCalculator, SWT.BORDER);
		resultText.setEditable(false);
		resultText.setLayoutData(checkBoxData);
	}

}
