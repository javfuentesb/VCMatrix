package cc3002.twitter.demo;

import java.awt.Color;

import cc3002.twitter.ui.*;
import cc3002.twitter.ui.UIFrame;
import cc3002.twitter.ui.shape.*;

public class MatrixDemo {
	public static void main(String[] args) {
		UIAdjancencyMatrix matrix=new UIAdjancencyMatrix(4,4);
		String[] cc3002Guys=new String[]{"juampi","pablo","andres","alex"};
		for(int i=0;i<cc3002Guys.length; i++){
			matrix.updateXLabel(cc3002Guys[i], i);	
			matrix.updateYLabel(cc3002Guys[i], i);
		}
		//filling with random colors
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				matrix.update(new UIBox(Math.random()>0.5?Color.RED:Color.BLUE), i, j);
			}
		}
		// changing cell 0 0
		matrix.update(new UICircle(Color.GREEN),0, 0);
		
		
		UIFrame frame=new UIFrame();
		frame.add(matrix);
		frame.setVisible(true);
	}
}
