package com.luxoft.calculator.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Shell;

import com.luxoft.calculator.model.ModelManager;

public class ViewManager {

	private static ViewManager viewManager;

	private CalculatorUI calculatorUI;
	private CalculatorUISupport calculatorUISupport;
	private HistoryUI historyUI;
	private HistoryUISupport historyUISupport;
	
	private ModelManager modelManager;

	public void createUI(Shell shell) {
		
		CTabFolder folder = new CTabFolder(shell, SWT.BORDER);
		folder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		modelManager = ModelManager.getInstance();
		modelManager.createModel();	
		
		calculatorUI = new CalculatorUI();
		calculatorUISupport = new CalculatorUISupport(calculatorUI);
		calculatorUI.createCalculatorUI(folder);
		calculatorUISupport.createCalculatorListeners();
		
		historyUI = new HistoryUI();
		historyUISupport = new HistoryUISupport(historyUI);
		historyUI.createHistotyUI(folder);
		historyUISupport.createHistoryListeners();
		
	}

	public static ViewManager getInstance() {
		if (viewManager == null) {
			viewManager = new ViewManager();
		}
		return viewManager;
	}

	public CalculatorUI getCalculateUI() {
		return calculatorUI;
	}

	public HistoryUI getHistoryUI() {
		return historyUI;
	}
}
