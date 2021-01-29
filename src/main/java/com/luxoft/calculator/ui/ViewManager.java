package com.luxoft.calculator.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Shell;

import com.luxoft.calculator.service.impl.HistoryServiceImpl;

public class ViewManager {
		
	private static ViewManager viewManager;
	
	private CalculaterUI calculateUI;
	private HistoryUI historyUI;

	public void createUI(Shell shell) {
		this.calculateUI = new CalculaterUI(new HistoryServiceImpl());
		this.historyUI = new HistoryUI(new HistoryServiceImpl());
		
		CTabFolder folder = new CTabFolder(shell, SWT.BORDER);
		folder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		calculateUI.createCalculaterUI(folder);
		calculateUI.createCalculatorEvents();
		historyUI.createHistotyUI(folder);
		historyUI.createHistoryEvents();
	}
	
	public static ViewManager getInstance() {
		if (viewManager == null) {
			viewManager = new ViewManager();
		}
		return viewManager;
	}

	public CalculaterUI getCalculateUI() {
		return calculateUI;
	}


	public HistoryUI getHistoryUI() {
		return historyUI;
	}
	
	
}
