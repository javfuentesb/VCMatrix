package cc3002.twitter.ui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import cc3002.tarea3.visualization.Main;
import cc3002.twitter.ui.shape.UIBox;
import cc3002.twitter.ui.shape.UICircle;

public class UIMatrixElementListener extends MouseAdapter{
	private UIAdjancencyMatrix matrix;
	private UIMatrixElement element;
	private Main main;
	int row;
	int column;
	
	public UIMatrixElementListener(UIMatrixElement element, UIAdjancencyMatrix matrix, Main main,int row, int column){
		this.matrix=matrix;
		this.element=element;
		this.row=row;
		this.column=column;
		this.main=main;
	}
	/**
	 * En caso que el mouse entre sobre el elemento
	 */
	public void mouseEntered(MouseEvent e){
		/**Cambiamos el color de los vértices correspondientes**/
		matrix.updateXLabel(row,Color.RED);
		matrix.updateYLabel(column, Color.RED);
		
		/**Cambiamos las figuras**/
		for(int i=0; i<matrix.getRange();i++){
			matrix.update(new UICircle(UIShape.DEFAULT_WIDTH,UIShape.DEFAULT_HEIGHT,matrix.getElementColor(row,i)), row, i);
			matrix.update(new UICircle(UIShape.DEFAULT_WIDTH,UIShape.DEFAULT_HEIGHT,matrix.getElementColor(i,column)),i,column);
		}
		String[] labels=matrix.getUILabelsText(row,column);
		int nbof=main.getTwitList().numberofTwits(labels);
		
		String title=main.getFrame().getTitle();
		title+= " ("+ nbof+ " twits)";
		main.getFrame().setTitle(title);
		
		matrix.repaint();
		
		
	}
	/**
	 * En caso que el mouse salga del elemento
	 */
	public void mouseExited(MouseEvent e){
		/**Cambiamos el color de los vértices correspondientes**/
		matrix.updateXLabel(row,Color.BLACK);
		matrix.updateYLabel(column, Color.BLACK);
		/**Cambiamos las figuras**/
		for(int i=0; i<matrix.getRange();i++){
			matrix.update(new UIBox(UIShape.DEFAULT_WIDTH,UIShape.DEFAULT_HEIGHT,matrix.getElementColor(row,i)), row, i);
			matrix.update(new UIBox(UIShape.DEFAULT_WIDTH,UIShape.DEFAULT_HEIGHT,matrix.getElementColor(i,column)),i,column);
		}
		
		String title=main.getFrame().getTitle();
		title=title.substring(0,title.indexOf('(')-1);
		main.getFrame().setTitle(title);
		
		matrix.repaint();
		
	}
	

}
