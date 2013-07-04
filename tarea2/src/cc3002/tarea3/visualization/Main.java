package cc3002.tarea3.visualization;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


import cc3002.tarea3.color.*;
import cc3002.tarea3.twit.TwitList;
import cc3002.tarea3.vertexorder.*;
import cc3002.twitter.ui.UIAdjancencyMatrix;
import cc3002.twitter.ui.UIFrame;
import cc3002.twitter.ui.shape.UICircle;

public class Main {
	VertexStrategy vertex_strategy;
	ColorStrategy color_strategy;
	TwitList twitlist;
	UIAdjancencyMatrix matrix;
	ArrayList<String> vertices;
	UIFrame frame;
	
	public Main(String[] data, String pathfile) throws FileNotFoundException{
		
		/**Pasamos arreglo de vértices a un arraylist, que es mas manejable**/
		vertices= new ArrayList<String>();
		for(int i=0;i<data.length;i++){
			vertices.add(data[i]);
		}
		
		/**Llenamos el TwitList**/
		twitlist= new TwitList();
		twitlist.addTwitsfromFile(pathfile);
		/**Creamos la matriz**/
		matrix=new UIAdjancencyMatrix(data.length,data.length,this);
		/**Seteamos estrategias de ordenamiento y coloreo por default**/
		vertex_strategy=new FrequencyOrder(twitlist);
		color_strategy=new GrayWhiteStrategy();
		
		frame=new UIFrame();
		frame.setTitle("Visual Co-ocurrence Matrix");
		
		/**Creamos la barra de menus**/
		JMenuBar menuBar=new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		/**Vertex Menu**/
		
		JMenu vertexMenu=new JMenu("Vertex Order");
		menuBar.add(vertexMenu);
		/**MenuItem para ordenar por frecuencia**/
		JMenuItem vertexStrategy1=new JMenuItem("By Frequency");
		vertexStrategy1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVertexStrategy(new FrequencyOrder(twitlist));
				vertex_strategy.orderVertex(vertices, matrix);
				color_strategy.colorate(matrix, twitlist, vertices);
				matrix.repaint();
			}
		});
		/**MenuItem para ordenar por orden alfabético**/
		JMenuItem vertexStrategy2=new JMenuItem("By Name");
		vertexStrategy2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVertexStrategy(new AlphabeticalOrder());
				vertex_strategy.orderVertex(vertices, matrix);
				color_strategy.colorate(matrix, twitlist, vertices);
				matrix.repaint();
			}
		});
		/**Añadimos los MenuItem al menu de vertices**/
		vertexMenu.add(vertexStrategy1);
		vertexMenu.add(vertexStrategy2);
		
		/**Color Menu**/
		
		JMenu ColorMenu= new JMenu("Color Algorithm");
		menuBar.add(ColorMenu);
		/**MenuItem para primera estrategia de coloreo**/
		JMenuItem colorStrategy1=new JMenuItem("Gray-White");
		colorStrategy1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setColorStrategy(new GrayWhiteStrategy());
				color_strategy.colorate(matrix, twitlist, vertices);
				matrix.repaint();
			}
		});
		/**MenuItem para segunda estrategia de coloreo**/
		JMenuItem colorStrategy2=new JMenuItem("Red-Yellow-White");
		colorStrategy2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setColorStrategy(new RedYellowWhiteStrategy());
				color_strategy.colorate(matrix, twitlist, vertices);
				matrix.repaint();
			}
		});
		ColorMenu.add(colorStrategy1);
		ColorMenu.add(colorStrategy2);
		/**Estrategia de coloreo y ordenamiento iniciales**/
		vertex_strategy.orderVertex(vertices,matrix);
		color_strategy.colorate(matrix, twitlist, vertices);
		
		/**Visualizamos**/
		frame.add(matrix);
		frame.setVisible(true);
	}

	public static void main(String[] args) throws FileNotFoundException {
		String[] data={"be","have","use","say","do","write","like","make","see","look","go","come","know", "call","find","work"
								,"take","get","live","show","give","think","help","mean","move","tell","want","play","put", 
								"read", "spell","follow","change","need","build","stand","own","answer"};
		String pathfile="./twitter/data.txt";
		new Main(data,pathfile);
		
	}
	/**
	 * Devuelve el objeto de tipo UIFrame asociado a una instancia dada de Main.
	 * @return el UIFrame de la instancia
	 */
	public UIFrame getFrame(){
		return frame;
	}
	/**
	 * Devuelve la lista de twits asociada a una instancia dada de Main.
	 * @return la lista de twits de la instancia
	 */
	public TwitList getTwitList(){
		return twitlist;
	}
	/**
	 * Setea una estraegia de ordenamento de vertices
	 * @param vertexstrategy estrategia a setear
	 */
	public void setVertexStrategy(VertexStrategy vertexstrategy){
		vertex_strategy=vertexstrategy;
	}
	/**
	 * Setea una estrategia de coloreo de la matriz
	 * @param colorstrategy estrategia a setear
	 */
	public void setColorStrategy(ColorStrategy colorstrategy){
		color_strategy=colorstrategy;
	}
	
	

}
