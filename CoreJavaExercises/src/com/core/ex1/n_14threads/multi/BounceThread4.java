package com.core.ex1.n_14threads.multi;

import java.awt.BorderLayout;
import java.awt.Component;
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
public class BounceThread4 {
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run() {
				JFrame frame = new BounceFrame();
				frame.setTitle("BounceThread");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
			
		});
	}
	
}

/**
 * A runnable that animates a bouncing ball
 * */
class BallRunnable implements Runnable{
	private Ball2 ball;
	private Component component;
	public static final int STEPS = 1000;
	public static final int DELAY = 5;

	public BallRunnable(Ball2 aBall, Component aComponent){
		ball = aBall;
		component = aComponent;
	}
	
	@Override
	public void run() {
		try	{
			for (int i = 1; i <= STEPS; i++){
				ball.move(component.getBounds());
				component.repaint();
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException e){
			
			
		//JFrame frame = new BounceFrame();
		//frame.setTitle("BounceThread");
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setVisible(true);
		}
	}	
}


/**
 * Frame with ball components and buttons
 * */
class BounceFrame extends JFrame{
	private BallComponent3 comp;
	//public static final int STEPS = 1000;
	//public static final int DELAY = 5;
	
	/**
	 * Constructs the frame
	 * */
	public BounceFrame(){
		//this.setTitle("BounceThread");
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
		Ball2 ball = new Ball2();
		comp.add(ball);
		Runnable r = new BallRunnable(ball, comp);
		Thread t = new Thread(r);
		t.start();
	}
}