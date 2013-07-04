package cc3002.twitter.ui.shape;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

public class UIHorizontalLabel extends UILabel{

	public static final int DEFAULT_WIDTH=80;
	public static final int DEFAULT_HEIGHT=10;
	public UIHorizontalLabel(String text) {
		super(text,DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g.setFont(getDesiredFont());
		Rectangle bounds = getStringBounds(g,text, 140,128);
		int y=(DEFAULT_HEIGHT-bounds.height)/2+DEFAULT_HEIGHT/2;
		int x=(DEFAULT_WIDTH-bounds.width)-DEFAULT_HEIGHT/2;
		g.drawString(text, x,y);
	}
	
}
