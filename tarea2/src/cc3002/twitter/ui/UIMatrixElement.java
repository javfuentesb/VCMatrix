package cc3002.twitter.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;

import cc3002.twitter.ui.shape.UIBox;

public class UIMatrixElement extends JComponent{


	private static final long serialVersionUID = 1L;
	private UIShape shape;
	
	public UIMatrixElement(){
		this(new UIBox());
		addMouseListener(new MouseAdapter() { 
	          public void mouseEntered(MouseEvent me) { 
	            
	          } 
	        }); 
	}
	
	public UIMatrixElement(UIShape shape){
		this.shape=shape;
	}
	
	public void setShape(UIShape shape){
		this.shape=shape;
		updateUI();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		shape.draw(g);
	}
	
	
	@Override
	public Dimension getPreferredSize() {
		return shape.getPreferredSize();
	}
	
	@Override
	public Dimension getMinimumSize() {
		return getPreferredSize();
	}
	
	@Override
	public Dimension getMaximumSize() {
		return getPreferredSize();
	}
	
}
