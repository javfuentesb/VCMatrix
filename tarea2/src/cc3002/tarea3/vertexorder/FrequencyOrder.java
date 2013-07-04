package cc3002.tarea3.vertexorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import cc3002.tarea3.twit.TwitList;
import cc3002.twitter.ui.UIAdjancencyMatrix;
/**
 * Clase que  implementa un algoritmo de ordenación de vértices por frecuencia de los mismos en una lista de twits determinada
 * @author Javier
 *
 */
public class FrequencyOrder extends VertexStrategy {
	private TwitList twits;
	
	/**
	 * Pedimos como parámetro la lista de twits sobre la que se evaluará la frecuencia de los vértices
	 * @param twits
	 */
	public FrequencyOrder(TwitList twits){
		this.twits=twits;
	}
	@Override
	public void orderVertex(ArrayList<String> vertices, UIAdjancencyMatrix matrix) {
		ArrayList<String> aux=new ArrayList<String>();
		int[] frequencies= new int[vertices.size()];
		/**Sacamos la frecuencia de cada palabra y guardamos ese número en un arreglo**/
		for(int i=0; i<vertices.size();i++){
			frequencies[i]=twits.numberofTwits(vertices.get(i));
		}
		
		/**En cada iteración encontramos el máximo del arreglo y lo agregamos a la lista auxiliar**/
		for(int i=0;i<vertices.size();i++){
			int max_pos=0;
			int max=frequencies[max_pos];
			
			/**Sacamos el máximo del arreglo**/
			for(int j=0;j<frequencies.length;j++){
				if(frequencies[j]>frequencies[max_pos]){
					max=frequencies[j];
					max_pos=j;
				}
			}
			/**Agregamos a la lista auxiliar**/
			if(max>=0){
				aux.add(vertices.get(max_pos));
				frequencies[max_pos]=-1;
			}
		}
		/**Borramos y copiamos la nueva lista**/
		vertices.clear();
		for(int i=0;i<aux.size();i++){
			vertices.add(aux.get(i));
		}
		
		/**Actualizamos la matriz con la lista de vértices ordenada**/
		super.UpdateLabels(vertices, matrix);
	}
	
}
