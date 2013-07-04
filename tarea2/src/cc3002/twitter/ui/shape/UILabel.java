package cc3002.twitter.ui.shape;



import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;

import cc3002.twitter.ui.UIShape;

public abstract class UILabel extends UIShape{
	
	protected String text;
	
	
	public UILabel(String text) {
		this.text = text;
	}
	
	public UILabel(String text,int width,int height) {
		super(width,height);
		this.text = text;
	}
	
	public void setText(String text){
		this.text=text;
	}
	protected Font getDesiredFont() {
			return new Font(Font.SANS_SERIF, Font.BOLD, 8);
	}
	protected Rectangle getStringBounds(Graphics g, String str, float x, float y) {
		Graphics2D g2=(Graphics2D)g;
        FontRenderContext frc = g2.getFontRenderContext();
        GlyphVector gv = g2.getFont().createGlyphVector(frc, str);
        return gv.getPixelBounds(null, x, y);
    }
	/**Añadido.
	 * Devuelve el texto que muestra el label
	 * @return String correspondiente al texto del label
	 */
	public String getText() {
		return text;
	}

}
