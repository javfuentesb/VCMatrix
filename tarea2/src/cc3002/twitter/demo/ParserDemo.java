package cc3002.twitter.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParserDemo {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in=new Scanner(new File("./twitter/data.txt"), "UTF-8");
		while(in.hasNext()){
			String line=in.nextLine();
			String[] data=line.split("\t",-1);
			System.out.println(data[0]);//name
			System.out.println(data[1]);//language
			System.out.println(data[2]);//message	
		}
	}
}
