package com.luxoft.calculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.luxoft.calculator.interfaces.Observable;
import com.luxoft.calculator.interfaces.Observer;

public class CalculationModel implements Observable{

	private double firstOperand;
	private double secondOperand;
	private String operationSymbol;
	
	private List<Observer> observers = new ArrayList<>();
	
	public CalculationModel() {}
	
	public CalculationModel(double firstOperand, double secondOperand, String operationSymbol) {
		this.firstOperand = firstOperand;
		this.secondOperand = secondOperand;
		this.operationSymbol = operationSymbol;
	}
	public double getFirstOperand() {
		return firstOperand;
	}
	public void setFirstOperand(double firstOperand) {
		this.firstOperand = firstOperand;
	}
	public double getSecondOperand() {
		return secondOperand;
	}
	public void setSecondOperand(double secondOperand) {
		this.secondOperand = secondOperand;
	}
	public String getOperationSymbol() {
		return operationSymbol;
	}
	public void setOperationSymbol(String operationSymbol) {
		this.operationSymbol = operationSymbol;
	}

	@Override
	public void addObserver(Observer observer) {
		this.observers.add(observer);		
	}

	@Override
	public void removeObserver(Observer observer) {
		this.observers.add(observer);		
	}

	@Override
	public void notifyObservers() {
		this.observers.forEach(observer -> observer.update(firstOperand, secondOperand, operationSymbol));		
	}
	
	public void setParameters(Map<String, String> parameters) {
		this.firstOperand = Double.valueOf(parameters.get("firstOperand"));
		this.secondOperand = Double.valueOf(parameters.get("secondOperand"));
		this.operationSymbol = parameters.get("operationSymbol");
		notifyObservers();
	}
	
}
