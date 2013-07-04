package cc3002.tarea3.color;

import java.util.ArrayList;

import cc3002.tarea3.twit.TwitList;
import cc3002.twitter.ui.UIAdjancencyMatrix;
/**
 * Interface que toda estrategia de coloreo debe implementar
 * @author Javier
 *
 */
public interface ColorStrategy {
/**
 * Método que actualiza los elementos de la matriz, coloreándolos según un criterio a implementar	
 * @param matrix matriz a actualizar
 * @param twitlist lista de twits
 * @param vertices lista  de vértices
 */
public void colorate(UIAdjancencyMatrix matrix, TwitList twitlist,ArrayList<String> vertices);

}

