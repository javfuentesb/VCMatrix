package cc3002.tarea2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import cc3002.twitter.ui.UIAdjancencyMatrix;
import cc3002.twitter.ui.UIFrame;
import cc3002.twitter.ui.shape.UIBox;
import cc3002.twitter.ui.shape.UICircle;

public class VisualizationDemo {

	/** Ejemplo de visualización de la matriz
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		UIFrame frame=new UIFrame();
		final String[] data={"be","have","use","say","do","write","like","make","see","look","go","come","know", "call","find","work"
						,"take","get","live","show","give","think","help","mean","move","tell","want","play","put", 
						"read", "spell","follow","change","need","build","stand","own","answer"};
		final TwitList twitlist= new TwitList();
		final UIAdjancencyMatrix matrix=new UIAdjancencyMatrix(data.length,data.length);
		final ColorStrategy actualstrategy= new ColorStrategy1(matrix,twitlist);
		
		twitlist.addTwitsfromFile("./twitter/data.txt");
		
		for(int i=0;i<data.length; i++){
			matrix.updateXLabel(data[i], i);	
			matrix.updateYLabel(data[i], i);
		}
		
		JMenuBar menuBar=new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu vertexMenu=new JMenu("Vertex Order");
		menuBar.add(vertexMenu);
		
		JMenuItem vertexStrategy1=new JMenuItem("Default");
		vertexStrategy1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				(new DefaultOrder(data,actualstrategy)).orderVertex();
				matrix.repaint();
			}
		});
		
		JMenuItem vertexStrategy2=new JMenuItem("Alphabetical");
		vertexStrategy2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				(new AlphabeticalOrder(data,actualstrategy)).orderVertex();
				matrix.repaint();
			}
		});
		
		vertexMenu.add(vertexStrategy1);
		vertexMenu.add(vertexStrategy2);
		
		actualstrategy.colorate(data);
		
		frame.add(matrix);
		frame.setVisible(true);
		
	}

}
