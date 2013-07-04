package cc3002.tarea2;

import java.util.Arrays;

import cc3002.twitter.ui.UIAdjancencyMatrix;

/**Muestra los vértices con la ordenación inicial**/

public class DefaultOrder implements VertexStrategy{
	private String[] data; /** Arreglo con los labels de los vértices**/
	private ColorStrategy strategy; /**Algoritmo de coloración a usar**/
	
	public DefaultOrder(String[] data,ColorStrategy strategy){
		this.data=data;
		this.strategy=strategy;

	}
	
	/**Solo se invoca colorate() para terminar coloreando la matriz **/
	public void orderVertex(){
		strategy.colorate(data);
	}

}
