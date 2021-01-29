package com.luxoft.calculator.model;

import java.util.LinkedList;

public class History {
	
	private static History history;
	
	private LinkedList<String> results = new LinkedList<String>();
	
	public static History getInstance() {
		if (history == null) {
			history = new History();
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
