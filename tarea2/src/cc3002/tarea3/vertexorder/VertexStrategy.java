package cc3002.tarea3.vertexorder;

import java.util.ArrayList;

import cc3002.twitter.ui.UIAdjancencyMatrix;
/**
 * Interface estándar que todo algoritmo de ordenación de vértices debe implementar
 * @author Javier
 *
 */
public abstract class VertexStrategy {
	/**
	 * Ordena un arraylist de vértices según algún criterio.
	 * @param vertices arraylist con los vértices
	 * @param matrix matriz de adyacencia utilizada
	 */
	public abstract void orderVertex(ArrayList<String> vertices, UIAdjancencyMatrix matrix);	
	/**
	 * Actualiza la matriz de adyacencia, seteando los labels de ésta según la lista de vértices
	 * @param vertices arraylist con los vértices
	 * @param matrix matriz de adyacencia a actualizar
	 */
	public void UpdateLabels(ArrayList<String> vertices, UIAdjancencyMatrix matrix){
		for(int i=0;i<vertices.size(); i++){
			matrix.updateXLabel(vertices.get(i), i);	
			matrix.updateYLabel(vertices.get(i), i);
		}
	}

}
