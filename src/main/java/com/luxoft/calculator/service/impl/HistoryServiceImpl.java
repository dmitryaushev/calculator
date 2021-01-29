package com.luxoft.calculator.service.impl;

import java.util.LinkedList;

import org.eclipse.swt.widgets.List;

import com.luxoft.calculator.model.History;
import com.luxoft.calculator.service.HistoryService;
import com.luxoft.calculator.ui.HistoryUI;
import com.luxoft.calculator.ui.ViewManager;

public class HistoryServiceImpl implements HistoryService{
	
	public void saveHistory(String result) {
		History history = History.getInstance();
		LinkedList<String> results = history.getResults();
		results.add(result);
		history.setResults(results);
		
		HistoryUI historyUI = ViewManager.getInstance().getHistoryUI();
		List historyList = historyUI.getHistory();
		historyList.setItems(results.toArray(new String[0]));
	}
	
	public void clearHistoty() {
		History history = History.getInstance();
		LinkedList<String> results = history.getResults();
		results.clear();
		
		HistoryUI historyUI = ViewManager.getInstance().getHistoryUI();
		List historyList = historyUI.getHistory();
		historyList.setItems(new String[0]);
	}

}
