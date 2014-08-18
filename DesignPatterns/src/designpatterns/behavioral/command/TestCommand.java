package designpatterns.behavioral.command;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class ExitAction extends AbstractAction{
	private Component target;
	
	public ExitAction(String name, Icon icon, Component t){
		putValue(Action.NAME, name);
		putValue(Action.SMALL_ICON, icon);
		putValue(Action.SHORT_DESCRIPTION, name + " the program");
	}
	
	public void actionPerformed(ActionEvent event){
		int answer = JOptionPane.showConfirmDialog(target,"Are you sure you want to exit?","Confirmation", JOptionPane.YES_NO_OPTION);
		if(answer==JOptionPane.YES_OPTION){
			System.exit(0);
		}
	}
}

class SubmitAction extends AbstractAction{
	private Component target;
	public SubmitAction(String name, Icon icon, Component t){
		putValue(Action.NAME, name);
		putValue(Action.SMALL_ICON, icon);
		putValue(Action.SHORT_DESCRIPTION, name+ "the program");
	}
	public void actionPerformed(ActionEvent evt){
		JOptionPane.showMessageDialog(target,"Submit action clicked");
	}
	
}

public class TestCommand extends JFrame{

	TestCommand() {
		Action ea = new ExitAction("Exit", null, this);
		Action sa = new SubmitAction("Submit", null, this);
		
		JMenuBar jbr = new JMenuBar();
		JMenu dropmenu = new JMenu("File");
		JMenuItem submitmenu = new JMenuItem(sa);
		JMenuItem exitmenu = new JMenuItem(ea);
		dropmenu.add(submitmenu);
		dropmenu.add(exitmenu);
		jbr.add(dropmenu);
		setJMenuBar(jbr);
		
		final JPopupMenu pop = new JPopupMenu("PopMenu");
		pop.add(sa);
		pop.add(ea);
		
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e){
				showPopup(e);
			}
			public void mouseReleased(MouseEvent e){
				showPopup(e);
			}
			private void showPopup(MouseEvent e){
				if(e.isPopupTrigger()){
					pop.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
		
		JPanel jp = new JPanel();
		JButton subbtn = new JButton(sa);
		JButton exitbtn = new JButton(ea);
		jp.add(subbtn);
		jp.add(exitbtn);
		Container con = getContentPane();
		con.add(jp, "South");
		
	setTitle("Command Pattern Example");
	setSize(400,200);
	setVisible(true);
	}
	
	public static void main(String[] args) {
		new TestCommand();
	}
}
