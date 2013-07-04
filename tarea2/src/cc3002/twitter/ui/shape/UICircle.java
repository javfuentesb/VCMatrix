package cc3002.twitter.ui.shape;

import java.awt.Color;
import java.awt.Graphics;

import cc3002.twitter.ui.UIShape;

public class UICircle extends UIShape{
	
	public UICircle(Color color){
		this(DEFAULT_WIDTH,DEFAULT_HEIGHT,color);
	}
	
	public UICircle(){
		this(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
	
	public UICircle(int width, int height, Color color) {
		super(width,height,color);
	}
	
	public UICircle(int width, int height) {
		super(width, height);
	}

	public void draw(Graphics g) {
		Color last=g.getColor();
		g.setColor(Color.BLACK);
		g.drawOval(cap, cap, width, height);
		g.setColor(color);
		g.fillOval(cap, cap, width, height);
		g.setColor(last);
	}
}
