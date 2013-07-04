package cc3002.twitter.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public abstract class UIShape {
	protected int width;
	protected int height;
	protected int cap;
	protected Color color;
	public static int DEFAULT_WIDTH=10;
	public static int DEFAULT_HEIGHT=10;
	
	public UIShape(){
		this(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
	
	public UIShape(int width,int height){
		this(width,height,Color.white);
	}
	
	public UIShape(int width, int height, Color color) {
		super();
		this.width = width;
		this.height = height;
		this.color = color;
		cap=1;
	}

	public abstract void draw(Graphics g);
	
	public Dimension getPreferredSize() {
		return new Dimension(width+2*cap, height+2*cap);
	}

	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
