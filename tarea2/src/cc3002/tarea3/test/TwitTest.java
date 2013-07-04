package cc3002.tarea3.test;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import cc3002.tarea3.twit.Twit;
import cc3002.tarea3.twit.TwitList;

public class TwitTest {
	TwitList twitlist;
	Twit twitter;
	
	@Before
	public void setUp(){
		twitlist=new TwitList();
	}
	
	
	@Test
	public void testTwit(){
		
		Twit twit1= new Twit("@qwerty","es",">el tumbler pls");
		Twit twit2= new Twit("@asdf","en","I love twitter!");

		twitlist.addTwit("@qwerty","es",">el tumbler pls");
		twitlist.addTwit(twit2);
		
		assertFalse(twit1.equals(twit2));
		assertTrue(twitlist.getTwit(0).equals(twit1));
		assertFalse(twitlist.getTwit(1).equals(twit1));
		assertTrue(twit1.inMessage(new String[]{"tumbler","pls"}));
		
		
	}
	@Test
	public void testTwitList() throws FileNotFoundException{
		Twit twit3= new Twit("@GracieWhitton","en","RT @GracieWhitton: I need 16 more followers to 2500. I know you are out there!! Come on folks. :)");
		twitlist.addTwitsfromFile("./twitter/data.txt");
		assertEquals(twitlist.numberofTwits(new String[]{"have","come"}),0);
		assertTrue(twitlist.getTwit(0).equals(twit3));
		assertEquals(twitlist.length(),200);
		twitlist.removeTwit(0);
		assertEquals(twitlist.length(),199);
	}


}
