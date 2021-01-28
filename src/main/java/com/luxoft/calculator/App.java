package com.luxoft.calculator;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.luxoft.calculator.ui.ViewManager;

public class App {
	public static void main(String[] args) {
		
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setLayout(new GridLayout());
		shell.setText("Calculator");
		shell.setMinimumSize(300, 320);

		ViewManager viewManager = ViewManager.getInstance();
		viewManager.createUI(shell);
		
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
		
		
	}
}
