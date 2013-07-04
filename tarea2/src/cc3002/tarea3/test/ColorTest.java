package cc3002.tarea3.test;

import static org.junit.Assert.*;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import cc3002.tarea3.color.ColorStrategy;
import cc3002.tarea3.color.GrayWhiteStrategy;
import cc3002.tarea3.color.RedYellowWhiteStrategy;
import cc3002.tarea3.twit.TwitList;
import cc3002.tarea3.vertexorder.FrequencyOrder;
import cc3002.tarea3.vertexorder.VertexStrategy;
import cc3002.twitter.ui.UIAdjancencyMatrix;

public class ColorTest {
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
	public void GrayWhitetest() {
		VertexStrategy vertex_strategy= new FrequencyOrder(twitlist);
		vertex_strategy.orderVertex(vertices, matrix);
		ColorStrategy color_strategy= new GrayWhiteStrategy();
		color_strategy.colorate(matrix, twitlist, vertices);
		assertEquals(matrix.getElementColor(0,0),Color.GRAY);
		color_strategy= new RedYellowWhiteStrategy();
		color_strategy.colorate(matrix, twitlist, vertices);
		assertEquals(matrix.getElementColor(0,0),Color.RED);
	}

}