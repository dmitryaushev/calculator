package com.luxoft.calculator.model;

public class OperationModel {

	private double firstOperand;
	private double secondOperand;
	private String operationSymbol;
	
	public OperationModel() {}
	
	public OperationModel(double firstOperand, double secondOperand, String operationSymbol) {
		super();
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
}
