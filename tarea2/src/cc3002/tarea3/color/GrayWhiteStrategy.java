package cc3002.tarea3.color;

import java.awt.Color;
import java.util.ArrayList;

import cc3002.tarea3.twit.TwitList;
import cc3002.twitter.ui.UIAdjancencyMatrix;
import cc3002.twitter.ui.shape.UIBox;
/**
 * Define un algoritmo que colorea un elemento de color blanco si la cantidad de twits que contienen
 *  los vértices asociados a éste es 0 o gris si la cantidad es mayor a 0
 * @author Javier
 *
 */
public class GrayWhiteStrategy implements ColorStrategy{
	/**
	 * Coloreamos según el algoritmo definido
	 * @param matrix matriz de adyacencia a actualizar
	 * @param twitlist lista de twits
	 * @param vertices lista de vértices
	 */
	@Override
	public void colorate(UIAdjancencyMatrix matrix, TwitList twitlist, ArrayList<String> vertices) {
		for (int i = 0; i < vertices.size(); i++) {
			for (int j = 0; j < vertices.size(); j++) {
				if(twitlist.numberofTwits(new String[]{vertices.get(i),vertices.get(j)})>0)
					matrix.update(new UIBox(Color.GRAY), i, j);
				else
					matrix.update(new UIBox(Color.WHITE), i, j);
			}
		}
		
	}
	
	
	


	


	
	
	
}

