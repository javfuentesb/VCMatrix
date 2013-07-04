package cc3002.tarea3.twit;

/** Clase para almacenar la información de un Twit
 * 
 * @author Javier
 *
 */

public class Twit {
	/**Nombre del usuario, idioma del twit y el mensaje**/
	private String name; 
	private String language;
	private String message;
	
	public Twit(String name, String language, String message){
		this.name=name;
		this.language=language;
		this.message=message;	
	}
	
	/** Getters para name, language y message**/
	
	public String getName(){
		return name;
	}
	
	public String getLanguage(){
		return language;
	}
	
	public String getMessage(){
		return message;
	}
	
	/**Determina si la cadena de strings está o no en el twit**/
	
	public boolean inMessage(String chain){
		if(message.indexOf(chain)!=-1)
			return true;		
		else
			return false;
	}
	
	public boolean inMessage(String[] chains){
		for(int i=0;i<chains.length;i++){
			if((message.indexOf(chains[i])==-1))
				return false;
		}
			return true;
	}
	
	
	/**Overloading del método equals**/
	public boolean equals(Twit twit){
		if(twit.getName().equals(this.name) && twit.getLanguage().equals(this.language) && twit.getMessage().equals(this.message))
			return true;
		
		else
			return false;
		}
	}

