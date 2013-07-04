package cc3002.twitter.ui.shape;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class UIVerticalLabel extends UILabel{
	
	public static final int DEFAULT_WIDTH=10;
	public static final int DEFAULT_HEIGHT=80;
	
	public UIVerticalLabel(String text) {
		super(text,DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setFont(getDesiredFont().deriveFont(AffineTransform.getRotateInstance(Math.toRadians(-90))));
	    g2d.drawString(text,
	    		(DEFAULT_WIDTH-getStringBounds(g,text, 140,128).width)/2+DEFAULT_WIDTH/2,
	    		DEFAULT_HEIGHT-DEFAULT_WIDTH/2);
	}
}
