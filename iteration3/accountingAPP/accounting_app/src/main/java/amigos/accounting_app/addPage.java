package amigos.accounting_app;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class addPage {
	JFrame addMain;
	JLabel background;
	ImageIcon backgroundIcon, frameIcon;
	
	JButton food, shopping, transportation, entertainment, travel, study;
	JButton salary, financialServer, other;
	JButton back, create;
	
	String condition = new String();
	
	addPage(){
		// set frame
		addMain = new JFrame("Home");
		addMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addMain.setLayout(null);
		addMain.setResizable(false);
		addMain.setSize(700, 900);
				
		// set frame icon
		frameIcon = new ImageIcon("resource\\icon.jpg");
		addMain.setIconImage(frameIcon.getImage());
				
		// set background
		backgroundIcon = new ImageIcon("resource\\background.png");
		background = new JLabel();
		background.setIcon(backgroundIcon);
		background.setBounds(0, 0, 700, 900);
		
		// set event button
		food = new JButton("food");
		food.setBounds(20, 30, 70, 50);
		shopping = new JButton("shopping");
		shopping.setBounds(110, 30, 110, 50);
		transportation = new JButton("transportation");
		transportation.setBounds(240, 30, 140, 50);
		entertainment = new JButton("entertainment");
		entertainment.setBounds(400, 30, 140, 50);
		travel = new JButton("travel");
		travel.setBounds(560, 30, 80, 50);
		study = new JButton("study");
		study.setBounds(20, 100, 80, 50);
		salary = new JButton("salary");
		salary.setBounds(110, 100, 80, 50);
		financialServer = new JButton("financial server");
		financialServer.setBounds(210, 100, 160, 50);
		other = new JButton("other");
		other.setBounds(390, 100, 80, 50);
		
		
		// set create button
		create = new JButton("create");
		create.setFont(new Font("Serif", Font.PLAIN, 14));
		create.setBounds(600, 800, 70, 50);
		
		// set back button
		back = new JButton("back");
		back.setFont(new Font("Serif", Font.PLAIN, 14));
		back.setBounds(10, 800, 70, 50);
		
		// add attributes to frame
		addMain.add(food);
		addMain.add(shopping);
		addMain.add(transportation);
		addMain.add(entertainment);
		addMain.add(travel);
		addMain.add(study);
		addMain.add(salary);
		addMain.add(financialServer);
		addMain.add(other);
		
		addMain.add(back);
		addMain.add(create);
		addMain.add(background);
	}
	
	void UI() {
		actionDetect();
		addMain.setVisible(true);
		
		// set condition
		condition = "open";
	}
	
	void actionDetect() {
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMain.setVisible(false);
				condition = "back to main";
			}
		});
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMain.setVisible(false);
				condition = "back to main";
			}
		});
	}
}
