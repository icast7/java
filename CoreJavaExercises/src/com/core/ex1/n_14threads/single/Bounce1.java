package com.core.ex1.n_14threads.single;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Shows an animated bouncing ball 
 * */
public class Bounce1 {
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){

			@Override
			public void run() {
				JFrame frame = new BounceFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			
		});
	}
	
}
/**
 * Frame with ball components and buttons
 * */
class BounceFrame extends JFrame{
	private BallComponent3 comp;
	public static final int STEPS = 1000;
	public static final int DELAY = 3;
	
	/**
	 * Constructs the frame
	 * */
	public BounceFrame(){
		this.setTitle("Bounce");
		comp = new BallComponent3();
		add(comp, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		addButton(buttonPanel, "Start", new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				addBall();
			}			
		});
		addButton(buttonPanel, "Close", new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});
		add(buttonPanel, BorderLayout.SOUTH);
		pack();
	}
	/**
	 * Adds a button to a container
	 * */
	private void addButton(Container c, String title, ActionListener listener) {
		JButton button = new JButton(title);
		c.add(button);
		button.addActionListener(listener);
	}
	
	/**
	 * Add bouncing ball
	 * */
	public void addBall(){
		try {
			Ball2 ball = new Ball2();
			comp.add(ball);
			
			for (int i=1; i<= STEPS; i++){
				ball.move(comp.getBounds());
				comp.paint(comp.getGraphics());
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException e){
			
		}
	}
}