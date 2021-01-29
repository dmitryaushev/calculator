package com.luxoft.calculator.ui;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import org.eclipse.swt.widgets.Button;

import com.luxoft.calculator.service.HistoryService;

public class HistoryUISupport {
	
	private HistoryUI historyUI;
	private HistoryService historyService;
	
	public HistoryUISupport(HistoryUI historyUI, HistoryService historyService) {
		super();
		this.historyUI = historyUI;
		this.historyService = historyService;
	}

	public void createHistoryListeners() {
		
		Button clear = historyUI.getClear();
		clear.addSelectionListener(widgetSelectedAdapter(event -> {
			historyService.clearHistoty();
		}));
	}
}
