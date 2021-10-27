package amigos.UI_DEMO;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class mainPage {
	JFrame f = new JFrame("main");
	JButton add = new JButton("add");
	JButton view = new JButton("view");
	JLabel name = new JLabel("Mini Accounting Tool");
	
	mainPage(){
		add.setBounds(150, 130, 200, 200);
		view.setBounds(650, 130, 200, 200);
		name.setFont(new Font("Mini Accounting Tool", Font.PLAIN, 20));
		name.setBounds(400, 0, 200, 200);
		
		f.add(add);
		f.add(view);
		f.add(name);
		f.setLayout(null);
		f.setSize(1000, 500);
	}
	
	
}
