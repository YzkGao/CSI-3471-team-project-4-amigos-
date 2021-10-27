package amigos.UI_DEMO;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class viewPage {
	JFrame f = new JFrame("View");
	
	JMenuBar mb = new JMenuBar();
	JMenu typeMenu = new JMenu("Type");
	JMenu event = new JMenu("Event");
	JMenuItem expense = new JMenuItem("expense");
	JMenuItem income = new JMenuItem("income");
	
	JMenuItem all = new JMenuItem("All"); // for type
	JMenuItem all1 = new JMenuItem("All");// for event
	JMenuItem travel = new JMenuItem("Travel");
	JMenuItem study = new JMenuItem("Study");
	JMenuItem shopping = new JMenuItem("Shopping");
	JMenuItem entertainment = new JMenuItem("Entertainment");
	JMenuItem work = new JMenuItem("Work");
	JMenuItem others = new JMenuItem("Others");
	
	JButton back = new JButton("Back");
	
	
	viewPage(){
		typeMenu.add(all);
		typeMenu.add(expense);
		typeMenu.add(income);
		event.add(all1);
		event.add(travel);
		event.add(study);
		event.add(shopping);
		event.add(entertainment);
		event.add(work);
		event.add(others);
		
		
		mb.add(typeMenu);
		mb.add(event);
		
		back.setBounds(50, 400, 65, 30);
		
		f.setLayout(null);
		f.setJMenuBar(mb);
		f.add(back);
		f.setSize(1000, 500);
	}
}
