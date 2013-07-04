package cc3002.tarea3.vertexorder;

import java.util.ArrayList;
import java.util.Collections;

import cc3002.twitter.ui.UIAdjancencyMatrix;

/**
 * Clase que implementa un algoritmo de ordenación de vertices por orden alfabético
 * @author Javier
 *
 */
public class AlphabeticalOrder extends VertexStrategy{
	
	@Override
	public void orderVertex(ArrayList<String> vertices, UIAdjancencyMatrix matrix) {
		/**Ordenamos por orden alfabético**/
		Collections.sort(vertices);
		/**Actualizamos la matriz**/
		super.UpdateLabels(vertices, matrix);
	}

}
