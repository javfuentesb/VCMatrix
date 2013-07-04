package cc3002.tarea3.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import cc3002.tarea3.twit.TwitList;
import cc3002.tarea3.visualization.Main;
import cc3002.twitter.ui.UIAdjancencyMatrix;

public class MainTest {
	TwitList twitlist;
	UIAdjancencyMatrix matrix;
	ArrayList<String> vertices;
	
	@Before
	public void setUp() throws FileNotFoundException{
		twitlist=new TwitList();
		twitlist.addTwitsfromFile("./twitter/data.txt");
		vertices= new ArrayList<String>();
		vertices.add("do");
		vertices.add("be");
		matrix= new UIAdjancencyMatrix(2,2);
	}
	
	@Test
	public void test() throws FileNotFoundException {
		String[] data={"be","have","use","say","do","write","like","make","see","look","go","come","know", "call","find","work"
				,"take","get","live","show","give","think","help","mean","move","tell","want","play","put", 
				"read", "spell","follow","change","need","build","stand","own","answer"};
		Main main= new Main(data,"./twitter/data.txt");
		
		assertTrue(twitlist.equals(main.getTwitList()));
		
	}

}
