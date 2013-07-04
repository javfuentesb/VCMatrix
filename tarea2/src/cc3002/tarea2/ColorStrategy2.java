package cc3002.tarea2;

import java.awt.Color;

import cc3002.twitter.ui.UIAdjancencyMatrix;
import cc3002.twitter.ui.shape.UIBox;

/**Clase que implementa otro algoritmo de coloreo
 * @author Javier
 *
 */

public class ColorStrategy2 implements ColorStrategy{
	private UIAdjancencyMatrix matrix;
	private TwitList twitlist;
	
	public ColorStrategy2(UIAdjancencyMatrix matrix, TwitList twitlist){
		this.matrix=matrix;
		this.twitlist=twitlist;
	}
	
	/**
	 * Método que colorea la matriz de adyacencia, recibe como parámetro el arreglo de strings que contiene los x e y labels
	 */
	public void colorate(String[] data){
		
		/**Actualizamos los x e y labels**/
		for(int i=0;i<data.length; i++){
			matrix.updateXLabel(data[i], i);	
			matrix.updateYLabel(data[i], i);
		}
		/**Algoritmo de coloreo: Si hay másde 20 twits se colorea rojo, si hay más de 5 se colorea amarillo, si hay al menos uno
		 * se colorea gris y si no hay ninguno se colorea blanco**/
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				if(twitlist.numberofTwits(new String[]{data[i],data[j]})>20)
					matrix.update(new UIBox(Color.RED), i, j);
				else if(twitlist.numberofTwits(new String[]{data[i],data[j]})>5)
					matrix.update(new UIBox(Color.YELLOW), i, j);
				
				else if(twitlist.numberofTwits(new String[]{data[i],data[j]})>0)
					matrix.update(new UIBox(Color.GRAY), i, j);
				else
					matrix.update(new UIBox(Color.WHITE), i, j);
			}
		}
	}
	
}