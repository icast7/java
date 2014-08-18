package designpatterns.behavioral.memento;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.border.*;

interface Command{
	void execute();
}

class Mediator{
	BtnDice btnDice;
	BtnPrevious btnPrevious;
	BtnClear btnClear;
	LblDisplay show;
	List<Object> list, undo;
	boolean restart = true;
	int counter = 0, ct = 0;
	
	Mediator(){
		list = new ArrayList<Object>();
		undo = new ArrayList<Object>();
	}
	
	void registerDice(BtnDice d){
		btnDice = d;
	}	
	void registerClear(BtnClear c){
		btnClear = c;
	}
	void registerPrevious(BtnPrevious p){
		btnPrevious =p;
	}
	void registerDisplay(LblDisplay d){
		show = d;
	}
	void clear(){
		list = new ArrayList<Object>();
		undo = new ArrayList<Object>();
		counter = 0;
		show.setText("0");
		btnDice.setEnabled(true);
	}
	void previous(){
		show.setForeground(Color.red);
		btnDice.setEnabled(false);
		if (undo.size() > 0){
			ct = undo.size()-1;
			Memento num = (Memento)undo.get(ct);
			show.setText(""+num.getNum());
			undo.remove(ct);
		}
		if (undo.size()==0){
			show.setText("0");
		}
	}	
	void throwit(){
		show.setForeground(Color.black);
		int num = (int)(Math.random()*6 + 1);
		int i = counter++;
		list.add(i, new Integer(num));
		undo.add(i, new Memento(num));
		show.setText(""+num);		
	}
}

public class TestMemento extends JFrame implements ActionListener{
	Mediator med = new Mediator();

	TestMemento(){
		JPanel p = new 	JPanel();
		p.add(new BtnDice(this, med));
		p.add(new BtnPrevious(this, med));
		p.add(new BtnClear(this, med));
		JPanel dice = new JPanel();
		LblDisplay lbl = new LblDisplay(med);
		dice.add(lbl);
		getContentPane().add(dice, "Center");
		getContentPane().add(p, "South");
		setTitle("Memento Pattern Example");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 200);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae){
		Command cmd = (Command)ae.getSource();
		cmd.execute();
	}
		
	public static void main(String[] args) {
			new TestMemento();
	}
}

class BtnDice extends JButton implements Command{
	Mediator med;
	BtnDice(ActionListener al, Mediator m){
		super("Throw Dice");
		addActionListener(al);
		med = m;
		med.registerDice(this);
	}	
	public void execute(){
		med.throwit();
	}
}

class BtnClear extends JButton implements Command{
	Mediator med;
	BtnClear(ActionListener al, Mediator m){
		super("Clear");
		addActionListener(al);
		med = m;
		med.registerClear(this);
	}
	public void execute(){
		med.clear();
	}	
}

class BtnPrevious extends JButton implements Command{
	Mediator med;
	BtnPrevious(ActionListener al, Mediator m){
		super("Previous");
		addActionListener(al);
		med = m;
		med.registerPrevious(this);
	}
	public void execute(){
		med.previous();
	}
}

class LblDisplay extends JLabel{
	Mediator med;
	LblDisplay(Mediator m){
		super("0",JLabel.CENTER);
		med = m;
		med.registerDisplay(this);
		setBackground(Color.white);
		setBorder(new EtchedBorder(Color.blue, Color.green));
		Font font = new Font("Arial", Font.BOLD, 40);
		setFont(font);
	}
}

class Memento{
	int num;
	Memento(int c){
		num = c;
	}
	int getNum(){
		return num;
	}
}