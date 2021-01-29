package com.luxoft.calculator.model;

import java.util.LinkedList;

public class HistoryModel {
	
	private static HistoryModel history;
	
	private LinkedList<String> results = new LinkedList<String>();
	
	public static HistoryModel getInstance() {
		if (history == null) {
			history = new HistoryModel();
		}
		return history;
	}

	public LinkedList<String> getResults() {
		return results;
	}

	public void setResults(LinkedList<String> results) {
		this.results = results;
	}
}
