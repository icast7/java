package com.core.ex1.n_14threads.single;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * Component that draws the balls
 * */
public class BallComponent3 extends JPanel{
	private static final int DEFAULT_WIDTH = 450;
	private static final int DEFAULT_HEIGHT = 350;
	
	private java.util.List<Ball2> balls = new ArrayList<>();
	
	/**
	 * Add ball to the component
	 * */
	public void add(Ball2 b){
		balls.add(b);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);//Erase background
		Graphics2D g2 = (Graphics2D) g;
		for (Ball2 b : balls){
			g2.fill(b.getShape());
		}
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}	
}
