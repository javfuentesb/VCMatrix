package cc3002.twitter.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class UIFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	public UIFrame(){
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
	}
	
	public void add(JComponent comp){
		add(comp,BorderLayout.CENTER);
		pack();
	}
}
