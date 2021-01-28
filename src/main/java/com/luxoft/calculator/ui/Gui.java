package com.luxoft.calculator.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Gui {
	
	private Shell shell;
	private CTabFolder folder;
	
	public void createGui(Display display) {

		shell = new Shell(display);
		shell.setText("SWT Calculator");
		shell.setLayout(new GridLayout());

		folder = new CTabFolder(shell, SWT.BORDER);
		folder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		new CalculateUI().createCalculateUI(folder);
		new HistoryUI().createHistotyUI(folder);

		shell.pack();
		shell.setMinimumSize(300, 320);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
