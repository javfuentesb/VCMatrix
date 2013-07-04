package cc3002.twitter.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import cc3002.twitter.ui.shape.UICircle;

public class UIMatrixElementListener extends MouseAdapter{
	private UIAdjancencyMatrix matrix;
	private UIMatrixElement element;
	int row;
	int column;
	public UIMatrixElementListener(UIMatrixElement element, UIAdjancencyMatrix matrix, int row, int column){
	}
	
	public void mouseEntered(MouseEvent e){
		System.out.println("hola");	
	}
	

}
