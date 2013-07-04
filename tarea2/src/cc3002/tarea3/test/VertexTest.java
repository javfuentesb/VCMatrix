package cc3002.tarea3.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import cc3002.tarea3.twit.TwitList;
import cc3002.tarea3.vertexorder.AlphabeticalOrder;
import cc3002.tarea3.vertexorder.FrequencyOrder;
import cc3002.tarea3.vertexorder.VertexStrategy;
import cc3002.twitter.ui.UIAdjancencyMatrix;

public class VertexTest {
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
	public void AlphabeticalTest() {
		VertexStrategy vertex_strategy=new AlphabeticalOrder();
		vertex_strategy.orderVertex(vertices, matrix);
		assertEquals(vertices.get(0),"be");	
	}
	
	@Test
	public void FrequencyTest() {
		VertexStrategy vertex_strategy=new FrequencyOrder(twitlist);
		vertex_strategy.orderVertex(vertices, matrix);
		int Do_twits=twitlist.numberofTwits("do");
		int Be_twits=twitlist.numberofTwits("be");
		assertTrue(Do_twits>Be_twits);
		assertEquals(vertices.get(0),"do");
	}

}
