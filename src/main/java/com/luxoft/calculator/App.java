package com.luxoft.calculator;

import org.eclipse.swt.widgets.Display;

import com.luxoft.calculator.ui.Gui;

public class App {
	public static void main(String[] args) {
		Display display = new Display();
		new Gui().createGui(display);
		display.dispose();
	}
}
