package com.luxoft.calculator.service.impl;

import java.util.LinkedList;

import org.eclipse.swt.widgets.List;

import com.luxoft.calculator.model.HistoryModel;
import com.luxoft.calculator.service.HistoryService;
import com.luxoft.calculator.ui.HistoryUI;
import com.luxoft.calculator.ui.ViewManager;

public class HistoryServiceImpl implements HistoryService{
	
	public void saveHistory(String result) {
		HistoryModel history = HistoryModel.getInstance();
		LinkedList<String> results = history.getResults();
		results.add(result);
		history.setResults(results);
		
		HistoryUI historyUI = ViewManager.getInstance().getHistoryUI();
		List historyList = historyUI.getHistory();
		historyList.setItems(results.toArray(new String[0]));
	}
	
	public void clearHistoty() {
		HistoryModel history = HistoryModel.getInstance();
		LinkedList<String> results = history.getResults();
		results.clear();
		
		HistoryUI historyUI = ViewManager.getInstance().getHistoryUI();
		List historyList = historyUI.getHistory();
		historyList.setItems(new String[0]);
	}

}
