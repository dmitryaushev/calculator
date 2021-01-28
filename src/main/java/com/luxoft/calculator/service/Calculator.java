package com.luxoft.calculator.service;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;

public class Calculator {
	
	public static String calculate(Text firstOperand, Text secondOperand, Combo operations) {
		
		double result = 0;
		try {
			double first = Double.valueOf(firstOperand.getText());
			double second = Double.valueOf(secondOperand.getText());

			switch (operations.getText()) {
			case "+":
				result = first + second;
				break;
			case "-":
				result = first - second;
				break;
			case "*":
				result = first * second;
				break;
			case "/":
				result = first / second;
				break;
			}

		} catch (NumberFormatException e) {
			return "wrong input";
		}
		return String.valueOf(result);
		
	}

}
