package amigos.accounting_app;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class mainPage {
	// frame attributes
	JFrame main;
	JLabel background, title;
	ImageIcon backgroundIcon, addIcon, viewIcon,frameIcon;
	JButton add, view;
	
	// link to other frame
	addPage addpage = new addPage();
	
	// indicate the condition of the frame
	String condition = new String();
	
	mainPage(){
		// set frame
		main = new JFrame("Home");
		main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		main.setLayout(null);
		main.setResizable(false);
		main.setSize(700, 900);
		
		// set frame icon
		frameIcon = new ImageIcon("resource\\icon.jpg");
		main.setIconImage(frameIcon.getImage());
		
		// set background
		backgroundIcon = new ImageIcon("resource\\background.png");
		background = new JLabel();
		background.setIcon(backgroundIcon);
		background.setBounds(0, 0, 700, 900);
		
		// set title
		title = new JLabel("Accounting Tool");
		title.setForeground(Color.pink);
		title.setFont(new Font("Serif", Font.PLAIN, 50));
		title.setBounds(160, 50, 550, 200);
		
		// set option buttons
		add = new JButton();
		addIcon = new ImageIcon("resource\\add.png");
		add.setIcon(addIcon);
		add.setBounds(170, 250, 320, 260);
		view = new JButton();
		viewIcon = new ImageIcon("resource\\view.png");
		view.setIcon(viewIcon);
		view.setBounds(170, 530, 320, 260);
		
		// add attributes to frame
		main.add(add);
		main.add(view);
		main.add(title);
		main.add(background);
	}
	
	void UI(){
		this.actionDetect();
		main.setVisible(true);
		
		// set condition
		condition = "open";
	}
	
	
	
	void actionDetect() {
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(false);
				condition = "close";
				addpage.UI();
			}
		});
		view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.setVisible(false);
				condition = "close";
			}
		});
		main.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	condition = "end";
		    }
		});
	}
}
