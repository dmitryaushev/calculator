package com.luxoft.calculator.interfaces;

import java.util.Map;

public interface Observable {
	void addObserver(Observer observer);
	void removeObserver(Observer observer);
	void notifyObservers();
}
