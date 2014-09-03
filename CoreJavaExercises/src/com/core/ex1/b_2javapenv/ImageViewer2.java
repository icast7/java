package com.core.ex1.b_2javapenv;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

public class ImageViewer2 {
		public static void main(String[] args){
			EventQueue.invokeLater(new Runnable(){
				public void run(){
					JFrame frame = new ImageViewerFrame();
					frame.setTitle("MyImageViewer");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				}				
			});
		}
}


class ImageViewerFrame extends JFrame{
	private JLabel label;
	private JFileChooser chooser;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 400;	
	
	public ImageViewerFrame(){
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		label = new JLabel();
		this.add(label);
		
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		
		JMenuItem openItem = new  JMenuItem("Open");
		menu.add(openItem);
		openItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				int result = chooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION){
					String name = chooser.getSelectedFile().getPath();
					label.setIcon(new ImageIcon(name));					
				}				
			}
		});
		
		JMenuItem exitItem = new JMenuItem("Exit");
		menu.add(exitItem);
		exitItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				System.exit(0);				
			}			
		});
	}
}