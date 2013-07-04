package cc3002.tarea3.twit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;
/** Define una lista con Twits, provee además de métodos para acceder y sacar información acerca de estos twits
 * 
 * @author Javier
 *
 */


public class TwitList {
	
	/**Nuestra lista de twits**/
	private ArrayList<Twit> twits;
	
	public TwitList(){
		twits= new ArrayList<Twit>();
	}

	/**Métodos para añadir twits a la lista**/
	public void addTwit(String name, String language, String message){
		twits.add(new Twit(name, language, message));
	}
	
	public void addTwit(Twit twit){
		twits.add(twit);
	}
	
	/**Estos remueven un twit de la lista**/
	
	public void removeTwit(int i){
		twits.remove(i);
	}
	public void removeTwit(Twit twit){
		twits.remove(twit);
	}
	
	/**Método para obtener un twit de la lista**/
	
	public Twit getTwit(int i){
		return twits.get(i);
	}
	
	/**Largo de la lista**/
	public int length(){
		return twits.size();
	}
	
	
	/** Función que entrega la cantidad twits que contienen una cadena de texto dada
	 * 
	 * @param chains Arreglo de strings
	 * @return cantidad de twits que tienen la cadena
	 */
	public int numberofTwits(String[] chains){
		int i=0;
		ListIterator<Twit> li= twits.listIterator();
		while(li.hasNext()){
			if((li.next().inMessage(chains)))
				i++;
		}
		return i;
	}
	
	public int numberofTwits(String chain){
		int i=0;
		ListIterator<Twit> li= twits.listIterator();
		while(li.hasNext()){
			if((li.next().inMessage(chain)))
				i++;
		}
		return i;
	}
	
	/** Permite añadir twits a partir de un archivo. Lee el archivo, lo parsea y almacena cada dato en un Twit
	 * 
	 * @param file dirección del archivo de texto
	 * @throws FileNotFoundException
	 */
	public void addTwitsfromFile(String file) throws FileNotFoundException{
		Scanner in=new Scanner(new File(file),"UTF-8");
		while(in.hasNext()){
			String line=in.nextLine();
			String[] data=line.split("\t",-1);	
			addTwit(data[0],data[1],data[2]);
		}
	}
	
	/**
	 * Overloading del metodo equals
	 * @param twitlist
	 * @return true si son iguales, false en caso contrario
	 */
	public boolean equals(TwitList twitlist){
		if(twitlist.length()==this.length()){
			for(int i=0;i<twitlist.length();i++){
				if(!twitlist.getTwit(i).equals(this.getTwit(i)))
					return false;
			}
			return true;
		}
		return false;
	}
	
}
