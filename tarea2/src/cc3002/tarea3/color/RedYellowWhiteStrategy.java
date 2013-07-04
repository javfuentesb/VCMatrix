package cc3002.tarea3.color;

import java.awt.Color;
import java.util.ArrayList;

import cc3002.tarea3.twit.TwitList;
import cc3002.twitter.ui.UIAdjancencyMatrix;
import cc3002.twitter.ui.shape.UIBox;

/**
 * Define un algoritmo que colorea un elemento de color rojo la cantidad de twits que contienen
 *  los vértices asociados a éste es mayor a 20, amarillo si dicha cantidad es mayor a 10 o blanco si ésta es menor que 10
 * @author Javier
 *
 */
public class RedYellowWhiteStrategy implements ColorStrategy {
	/**
	 * Coloreamos según el algoritmo definido
	 * @param matrix matriz de adyacencia a actualizar
	 * @param twitlist lista de twits
	 * @param vertices lista de vértices
	 */
	@Override
	public void colorate(UIAdjancencyMatrix matrix, TwitList twitlist, ArrayList<String> vertices) {
		/**Algoritmo de coloreo: Si hay más de 20 twits se colorea rojo, si hay más de 10 se colorea amarillo y si hay menos de 10 se colorea blanco**/
		for (int i = 0; i < vertices.size(); i++) {
			for (int j = 0; j < vertices.size(); j++) {
				if(twitlist.numberofTwits(new String[]{vertices.get(i),vertices.get(j)})>20)
					/**Coloreamos rojo**/
					matrix.update(new UIBox(Color.RED), i, j);
				else if(twitlist.numberofTwits(new String[]{vertices.get(i),vertices.get(j)})>10)
					/**Coloreamos amarillo**/
					matrix.update(new UIBox(Color.YELLOW), i, j);
				else
					/**Coloreamos blanco**/
					matrix.update(new UIBox(Color.WHITE), i, j);
			}
		}
		
	}

}
