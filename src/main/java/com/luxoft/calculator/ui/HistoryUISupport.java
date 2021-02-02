package com.luxoft.calculator.ui;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import org.eclipse.swt.widgets.Button;

public class HistoryUISupport {
	
	private HistoryUI historyUI;
	
	public HistoryUISupport(HistoryUI historyUI) {
		super();
		this.historyUI = historyUI;
	}

	public void createHistoryListeners() {
		
		Button clear = historyUI.getClear();
		clear.addSelectionListener(widgetSelectedAdapter(event -> {
			historyUI.getHistory().setItems(new String[0]);
		}));
	}
}
