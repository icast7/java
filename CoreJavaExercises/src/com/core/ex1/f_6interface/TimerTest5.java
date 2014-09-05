/**
 * 
 */
package com.core.ex1.f_6interface;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * Callback
 * @author icastillejos
 */
public class TimerTest5 {
	
	public static void main(String[] args){
		ActionListener listener = new TimePrinter();
		
		//Construct a timer
		Timer t = new Timer(10000, listener);
		t.start();
		
		JOptionPane.showMessageDialog(null, "Quit Program?");
		System.exit(0);
	}
}

class TimePrinter implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		Date now = new Date();
		System.out.println("At the tone, the time is "+now);
		Toolkit.getDefaultToolkit().beep();		
	}
	
}