package cc3002.tarea2;

import java.awt.Color;

import cc3002.twitter.ui.UIAdjancencyMatrix;
import cc3002.twitter.ui.shape.UIBox;

/**Clase que implementa un algoritmo de coloreo específico**/

public class ColorStrategy1 implements ColorStrategy{
	private UIAdjancencyMatrix matrix;
	private TwitList twitlist;
	
	public ColorStrategy1(UIAdjancencyMatrix matrix,TwitList twitlist){
		this.matrix=matrix;
		this.twitlist=twitlist;
	}
	
	/**Método encargado de colorear la matriz
	 * @param data Arreglo de strings a evaluar
	 */
	public void colorate(String[] data){
		/**Actualizamos los labels**/
		for(int i=0;i<data.length; i++){
			matrix.updateXLabel(data[i], i);	
			matrix.updateYLabel(data[i], i);
		}
		/**Estrategia de coloreo: Si hay al menos un twit que contenga la cadena de strings, la celda se colorea de gris,
		 *  si no hay ninguno se colorea de blanco**/
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				if(twitlist.numberofTwits(new String[]{data[i],data[j]})>0)
					matrix.update(new UIBox(Color.GRAY), i, j);
				else
					matrix.update(new UIBox(Color.WHITE), i, j);
			}
		}
		
	}

	
	
	
}
