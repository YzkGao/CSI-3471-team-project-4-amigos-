package amigos.UI_DEMO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class addPage {
	String category = "";
	double amount = 0.0;
	String type = "";
	
	JFrame f = new JFrame("Add");
	JButton back = new JButton("Back");
	JButton add = new JButton("Add");
	
	JButton travel = new JButton("Travel");
	JButton shopping = new JButton("Shopping");
	JButton study = new JButton("Study");
	JButton work = new JButton("Work");
	JButton entertainment = new JButton("Entertainment");
	JButton others = new JButton("Others");
	
	JButton expense = new JButton("expense");
	JButton income = new JButton("income");
	
	
	JLabel categoryLabel = new JLabel("Category:");
	JLabel categoryLabel1 = new JLabel(this.category);
	JButton addAmount = new JButton("Add amount");
	
	JLabel amountLabel = new JLabel("Amount:");
	JLabel amountLabel1 = new JLabel(String.valueOf(amount));
	
	JLabel typeLabel = new JLabel("Type: ");
	JLabel typeLabel1 = new JLabel(this.type);
	
	JLabel comment = new JLabel("Comment:");
	JTextField commentTXT = new JTextField();
	
	
	addPage(){
		travel.setBounds(50, 30, 120, 40);
		shopping.setBounds(200, 30, 120, 40);
		study.setBounds(350, 30, 120, 40);
		work.setBounds(500, 30, 120, 40);
		entertainment.setBounds(650, 30, 120, 40);
		others.setBounds(800, 30, 120, 40);
		
		
		categoryLabel.setBounds(50, 60, 100, 100);
		categoryLabel1.setBounds(110, 60, 100, 100);
		
		amountLabel.setBounds(50, 100, 100, 100);
		amountLabel1.setBounds(110, 100, 100, 100);
		addAmount.setBounds(200, 140, 110, 20);
		
		typeLabel.setBounds(50, 140, 100, 100);
		typeLabel1.setBounds(110, 140, 100, 100);
		expense.setBounds(200, 180, 110, 20);
		income.setBounds(320, 180, 110, 20);
		
		comment.setBounds(50, 180, 100, 100);
		commentTXT.setBounds(115, 225, 600, 30);
		
		back.setBounds(50, 400, 65, 30);
		add.setBounds(870, 400, 65, 30);
		
		f.add(categoryLabel);
		f.add(categoryLabel1);
		f.add(amountLabel);
		f.add(amountLabel1);
		
		f.add(addAmount);
		
		f.add(typeLabel);
		f.add(typeLabel1);
		f.add(expense);
		f.add(income);
		
		f.add(comment);
		f.add(commentTXT);
		
		f.add(travel);
		f.add(shopping);
		f.add(study);
		f.add(work);
		f.add(entertainment);
		f.add(others);
		
		f.add(back);
		f.add(add);
		f.setLayout(null);
		f.setSize(1000,500);
	}
	
}
