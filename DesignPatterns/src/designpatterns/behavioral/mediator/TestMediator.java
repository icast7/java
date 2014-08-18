package designpatterns.behavioral.mediator;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


interface Command{
	void execute();
}

class TestMediator extends JFrame implements ActionListener {
	Mediator med = new Mediator();
	TestMediator(){
		JPanel p = new JPanel();
		p.add(new BtnView(this, med));
		p.add(new BtnBook(this, med));
		p.add(new BtnSearch(this, med));
		getContentPane().add(new LblDisplay(med), "North");
		getContentPane().add(p, "South");
		setSize(400, 200);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		Command cmd = (Command)ae.getSource();
		cmd.execute();
	}	
	public static void main(String[] args) {
		new TestMediator();
	}
}

class LblDisplay extends JLabel{
	Mediator med;
	LblDisplay(Mediator m){
		super("Just starting...");
		med = m;
		med.registerDisplay(this);
		setFont(new Font("Arial", Font.BOLD,24));
	}
}

class BtnBook extends JButton implements Command{
	Mediator med;
	BtnBook(ActionListener al, Mediator m){
		super("Book");
		addActionListener(al);
		med = m;
		med.registerBook(this);
	}
	public void execute(){
		med.book();
	}
}
class BtnView extends JButton implements Command{
	Mediator med;
	BtnView(ActionListener al, Mediator m){
		super("View");
		addActionListener(al);
		med = m ;
		med.registerView(this);
	}
	public void execute(){
		med.view();
	}
}
class BtnSearch extends JButton implements Command{
	Mediator med;
	BtnSearch(ActionListener al, Mediator m){
		super("Search");
		addActionListener(al);
		med = m;
		med.registerSearch(this);
	}
	public void execute(){
		med.search();
	}
}

class Mediator{
	BtnView btnView;
	BtnSearch btnSearch;
	BtnBook btnBook;
	LblDisplay show;
	void registerSearch(BtnSearch s){
		btnSearch = s;
	}
	void registerView(BtnView v){
		btnView = v;
	}
	void registerBook(BtnBook b){
		btnBook = b;	
	}	
	void registerDisplay(LblDisplay d){
		show = d;
	}
	void book(){
		btnBook.setEnabled(false);
		btnView.setEnabled(true);
		btnSearch.setEnabled(true);
		show.setText("booking...");
	}
	void view(){
		btnBook.setEnabled(false);
		btnView.setEnabled(true);
		btnSearch.setEnabled(true);
		show.setText("viewing...");
	}
	void search(){
		btnBook.setEnabled(false);
		btnView.setEnabled(true);
		btnSearch.setEnabled(true);
		show.setText("searching...");
	}
}