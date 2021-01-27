package com.luxoft.calculator;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class Gui {

	public void createGui() {

		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("SWT Calculator");
		shell.setLayout(new GridLayout());

		CTabFolder folder = new CTabFolder(shell, SWT.BORDER);
		folder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Composite compositeCalculator = new Composite(folder, SWT.NONE);
		compositeCalculator.setLayout(new GridLayout(3, false));
		CTabItem calculateTab = new CTabItem(folder, SWT.NONE);
		calculateTab.setText("calculator");
		calculateTab.setControl(compositeCalculator);

		Composite compositeHistory = new Composite(folder, SWT.NONE);
		compositeHistory.setLayout(new GridLayout());
		CTabItem historyTab = new CTabItem(folder, SWT.NONE);
		historyTab.setText("history");
		historyTab.setControl(compositeHistory);

		GridData operandsData = new GridData(GridData.VERTICAL_ALIGN_FILL);

		Text firstOperand = new Text(compositeCalculator, SWT.BORDER);
		firstOperand.setLayoutData(operandsData);

		Combo combo = new Combo(compositeCalculator, SWT.DROP_DOWN);
		combo.setItems(new String[] { "+", "-", "*", "/" });
		combo.select(0);
		combo.setLayoutData(operandsData);

		Text secondOperand = new Text(compositeCalculator, SWT.BORDER);
		secondOperand.setLayoutData(operandsData);

		GridData checkBoxData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		checkBoxData.horizontalSpan = 2;

		Button checkBox = new Button(compositeCalculator, SWT.CHECK);
		checkBox.setText("calculate on the fly");
		checkBox.setLayoutData(checkBoxData);

		Button calculateButton = new Button(compositeCalculator, SWT.PUSH);
		calculateButton.setText("calculate");
		calculateButton.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

		Label label = new Label(compositeCalculator, SWT.NONE);
		label.setText("result:");
		Text resultText = new Text(compositeCalculator, SWT.BORDER);
		resultText.setEditable(false);
		resultText.setLayoutData(checkBoxData);

		List history = new List(compositeHistory, SWT.BORDER);
		GridData historyData = new GridData(GridData.FILL_BOTH);
		history.setLayoutData(historyData);

		Button clear = new Button(compositeHistory, SWT.PUSH);
		clear.setText("clear");

		shell.pack();
		shell.setSize(500, 500);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}
}
