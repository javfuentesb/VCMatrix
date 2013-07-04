package cc3002.twitter.ui.shape;

import java.awt.Color;
import java.awt.Graphics;

import cc3002.twitter.ui.UIShape;


public class UIBox extends UIShape{
	
	public UIBox(Color color){
		this(DEFAULT_WIDTH,DEFAULT_HEIGHT,color);
	}
	
	public UIBox(){
		this(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
	
	public UIBox(int width, int height, Color color) {
		super(width,height,color);
	}
	
	public UIBox(int width, int height) {
		super(width, height);
	}

	public void draw(Graphics g) {
		Color last=g.getColor();
		g.setColor(Color.BLACK);
		g.drawRect(cap, cap, width, height);
		g.setColor(color);
		g.fillRect(cap, cap, width, height);
		g.setColor(last);
	}
}
