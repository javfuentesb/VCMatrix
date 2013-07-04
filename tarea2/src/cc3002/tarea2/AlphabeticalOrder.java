package cc3002.tarea2;

import java.util.Arrays;

import cc3002.twitter.ui.UIAdjancencyMatrix;

/**Clase que implementa un algoritmo de ordenación de vértices por orden alfabético**/

public class AlphabeticalOrder implements VertexStrategy{
	private String[] data;/** Arreglo con los labels de los vértices**/
	private ColorStrategy strategy;/**Algoritmo de coloración a usar**/
	
	public AlphabeticalOrder(String[] data, ColorStrategy strategy){
		this.data=data;
		this.strategy=strategy;
	}
	/**Ordena los vértices afabéticamente, se utiliza un copia de data para evitar modificar el arreglo original**/
	public void orderVertex(){
		String[] aux=new String[data.length];
		System.arraycopy(data, 0, aux, 0, data.length);
		Arrays.sort(aux);
		strategy.colorate(aux);
	}
	
	
		
}
