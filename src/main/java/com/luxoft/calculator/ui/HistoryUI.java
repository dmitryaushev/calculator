package com.luxoft.calculator.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;

public class HistoryUI {

	private Composite compositeHistory;
	private CTabItem historyTab;

	private List history;
	private Button clear;

	public Button getClear() {
		return clear;
	}

	public List getHistory() {
		return history;
	}
	
	public void createHistotyUI(CTabFolder parent) {

		compositeHistory = new Composite(parent, SWT.NONE);
		compositeHistory.setLayout(new GridLayout());
		historyTab = new CTabItem(parent, SWT.NONE);
		historyTab.setText("history");
		historyTab.setControl(compositeHistory);

		history = new List(compositeHistory, SWT.BORDER | SWT.V_SCROLL);
		GridData historyData = new GridData(GridData.FILL_BOTH);
		history.setLayoutData(historyData);

		clear = new Button(compositeHistory, SWT.PUSH);
		clear.setText("clear");
	}
}
