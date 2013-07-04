package cc3002.twitter.ui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

import cc3002.twitter.ui.shape.UIHorizontalLabel;
import cc3002.twitter.ui.shape.UIVerticalLabel;

public class UIAdjancencyMatrix extends JComponent{

	private static final long serialVersionUID = 1L;
	
	private UIMatrixElement[] xLabels;
	private UIMatrixElement[] yLabels;
	private UIMatrixElement[][] elements;
	
	public UIAdjancencyMatrix(int n,int m){
		elements=new UIMatrixElement[m][n];
		xLabels=new UIMatrixElement[m];
		yLabels=new UIMatrixElement[n];
		configure();
		buildTopPanel();
		buildLeftPanel();
		build();
	}
	public void updateXLabel(String label,int i){
		xLabels[i].setShape(new UIVerticalLabel(label));
		updateUI();
	}
	
	public void updateYLabel(String label,int j){
		yLabels[j].setShape(new UIHorizontalLabel(label));
		updateUI();
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
				elements[i][j].addMouseListener(new UIMatrixElementListener(elements[i][j],this,i,j));
				c.gridx=i;
				c.gridy=j;
				center.add(elements[i][j],c);
			}
		}
		add(center,BorderLayout.CENTER);
	}

}
