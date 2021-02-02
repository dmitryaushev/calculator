package com.luxoft.calculator.service;

import java.util.Map;

public interface Observable {
	void addObserver(Observer observer);
	void removeObserver(Observer observer);
	void notifyObservers();
}
