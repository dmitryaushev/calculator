package com.luxoft.calculator.ui;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;

import com.luxoft.calculator.service.HistoryService;

public class HistoryUI {

	private Composite compositeHistory;
	private CTabItem historyTab;

	private List history;
	private Button clear;

	private GridData historyData;

	private HistoryService historyService;

	public HistoryUI(HistoryService historyService) {
		this.historyService = historyService;
	};

	public void createHistotyUI(CTabFolder parent) {

		compositeHistory = new Composite(parent, SWT.NONE);
		compositeHistory.setLayout(new GridLayout());
		historyTab = new CTabItem(parent, SWT.NONE);
		historyTab.setText("history");
		historyTab.setControl(compositeHistory);

		history = new List(compositeHistory, SWT.BORDER | SWT.V_SCROLL);
		historyData = new GridData(GridData.FILL_BOTH);
		history.setLayoutData(historyData);

		clear = new Button(compositeHistory, SWT.PUSH);
		clear.setText("clear");
	}

	public void createHistoryEvents() {
		clear.addSelectionListener(widgetSelectedAdapter(event -> {
			historyService.clearHistoty();
		}));
	}

	public List getHistory() {
		return history;
	}
}
