package cc3002.twitter.ui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

import cc3002.tarea3.visualization.Main;
import cc3002.twitter.ui.shape.UIHorizontalLabel;
import cc3002.twitter.ui.shape.UIVerticalLabel;

public class UIAdjancencyMatrix extends JComponent{

	private static final long serialVersionUID = 1L;
	
	private UIMatrixElement[] xLabels;
	private UIMatrixElement[] yLabels;
	private UIMatrixElement[][] elements;
	private Main main;
	
	public UIAdjancencyMatrix(int n,int m){
		elements=new UIMatrixElement[m][n];
		xLabels=new UIMatrixElement[m];
		yLabels=new UIMatrixElement[n];
		configure();
		buildTopPanel();
		buildLeftPanel();
		build();
	}
	
	/**Añadido.
	 * Constructor que recibe además una instancia de la clase main
	 * @param n
	 * @param m
	 * @param main
	 */
	public UIAdjancencyMatrix(int n, int m, Main main){
		elements=new UIMatrixElement[m][n];
		xLabels=new UIMatrixElement[m];
		yLabels=new UIMatrixElement[n];
		this.main=main;
		configure();
		buildTopPanel();
		buildLeftPanel();
		build();	
	}
	public void updateXLabel(String label,int i){
		xLabels[i].setShape(new UIVerticalLabel(label));
		updateUI();
	}
	/**Añadido.
	 * Cambia el color del un VerticalLabel dado
	 * @param i fila de la matriz
	 * @param color Color del label
	 */
	public void updateXLabel(int i, Color color){
		UIVerticalLabel xlabel=(UIVerticalLabel) xLabels[i].getShape();
		xlabel.setColor(color);
		updateUI();
	}
	
	public void updateYLabel(String label,int j){
		yLabels[j].setShape(new UIHorizontalLabel(label));
		updateUI();
	}
	
	/**Añadido.
	 * Cambia el color del un HorizontalLabel dado
	 * @param i columna de la matriz
	 * @param color Color del label
	 */
	public void updateYLabel(int j, Color color){
		UIHorizontalLabel ylabel=(UIHorizontalLabel) yLabels[j].getShape();
		ylabel.setColor(color);
		updateUI();
	}
	/**Añadido
	 * Devuelve el color del elemento de la matriz pedido
	 * @param row fila de la matriz
	 * @param column columna de la matriz
	 * @return color del elemento
	 */
	public Color getElementColor(int row, int column){
		return elements[row][column].getShape().getColor();
	}
	/**Añadido
	 * Devuelve un arreglo de Strings con el texto de los labels de la componente (i,j) de la matriz
	 * @param i fila de la matriz
	 * @param j columna de la matriz
	 * @return arreglo con los textos de cada label
	 */
	public String[] getUILabelsText(int i,int j){
		UIVerticalLabel xlabel=(UIVerticalLabel) xLabels[i].getShape();
		UIHorizontalLabel ylabel=(UIHorizontalLabel) yLabels[j].getShape();
		return new String[]{xlabel.getText(),ylabel.getText()};
	}
	
	public void update(UIShape shape,int i, int j){
		elements[i][j].setShape(shape);
		updateUI();
	}
	public void buildTopPanel(){
		JPanel topPanel=new JPanel();
		topPanel.setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		for (int i = 0; i < xLabels.length; i++) {
			xLabels[i]=new UIMatrixElement(new UIVerticalLabel(""));
			c.gridx=i;
			c.gridy=0;
			topPanel.add(xLabels[i]);
		}
		JPanel dummy=new JPanel();
		dummy.setLayout(new BorderLayout());
		dummy.add(topPanel,BorderLayout.EAST);
		add(dummy,BorderLayout.NORTH);
	}
	public void buildLeftPanel(){
		JPanel leftPanel=new JPanel();
		leftPanel.setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		for (int i = 0; i < 	yLabels.length; i++) {
			yLabels[i]=new UIMatrixElement(new UIHorizontalLabel(""));
			c.gridx=0;
			c.gridy=i;
			leftPanel.add(yLabels[i],c);
		}
		add(leftPanel,BorderLayout.WEST);
	}
	
	/**
	 * Añadido.
	 * Devuelve el rango de la matriz
	 * @return rango
	 */
	public int getRange(){
		return elements.length;
	}
	
	private void configure(){
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
	}
	
	private void build(){
		JPanel center=new JPanel();
		center.setBackground(Color.WHITE);
		center.setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		for (int i = 0; i < xLabels.length; i++) {
			for (int j = 0; j < yLabels.length; j++) {
				elements[i][j]=new UIMatrixElement();
				elements[i][j].addMouseListener(new UIMatrixElementListener(elements[i][j],this,main,i,j)); /**Añadimos el listener**/
				c.gridx=i;
				c.gridy=j;
				center.add(elements[i][j],c);
			}
		}
		add(center,BorderLayout.CENTER);
	}

}
