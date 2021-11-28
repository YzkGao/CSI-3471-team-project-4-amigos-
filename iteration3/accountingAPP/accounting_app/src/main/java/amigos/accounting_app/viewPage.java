/*
 * Team: 4 amigos
 * Members: Maiqi Hou, Jingke Shi, Yangzekun Gao, Zhengyan Hu
 * 
 * File description: This function creates the view page.
 */
package amigos.accounting_app;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import javax.swing.DefaultButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class viewPage {
	
	JFrame viewMain;
	JLabel background;
	ImageIcon backgroundIcon, frameIcon;
	JButton back, delete;
	
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem export;
	
	static JLabel date, balance, totalExpense, totalIncome;
	
	Calendar calendar;  // table range
	
	accountingTable table; // the record table
	
	JFileChooser chooser;  // export file chooser;
	
	// warning for deletion
	JFrame warn;
	
	// indicate the condition of the frame
    String condition = new String();
    
	/*
	 * Function name: viewPage
	 * Description: The default constructor.
	 */
	viewPage() throws FileNotFoundException{
		// set frame
		viewMain = new JFrame("viewing");
		viewMain.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // only main page supports close function
		viewMain.setLayout(null);
		//viewMain.setResizable(false);
		viewMain.setSize(900, 900);
		frameIcon = new ImageIcon("resource\\icon.jpg");
		viewMain.setIconImage(frameIcon.getImage());
		
		// set background
		backgroundIcon = new ImageIcon("resource\\background.png");
		background = new JLabel();
		background.setIcon(backgroundIcon);
		background.setBounds(0, 0, 900, 900);
		
		// set menu
		menuBar = new JMenuBar();
		menu = new JMenu("function");
		export = new JMenuItem("export");
		menu.add(export);
		menuBar.add(menu);

		
		// set date
		date = new JLabel();
		date.setFont(new Font("Serif", Font.PLAIN, 20));
		date.setBounds(20, 30, 250, 50);
		
		// set statistic
		balance = new JLabel();
		totalExpense = new JLabel();
		totalIncome = new JLabel();
		balance.setFont(new Font("Serif", Font.PLAIN, 20));
		totalExpense.setFont(new Font("Serif", Font.PLAIN, 20));
		totalIncome.setFont(new Font("Serif", Font.PLAIN, 20));
		
		balance.setBounds(20, 80, 250, 50);
		totalExpense.setBounds(250, 80, 250, 50);
		totalIncome.setBounds(480, 80, 250, 50);
		
		// set table
		table = new accountingTable();
		
		// set delete button
		delete = new JButton("delete");
		delete.setBounds(750, 700, 100, 100);
		
		// set back button
		back = new JButton("back");
		back.setFont(new Font("Serif", Font.PLAIN, 14));
		back.setBounds(10, 780, 70, 50);
		
		// add attributes to frame
		viewMain.setJMenuBar(menuBar);
		viewMain.add(date);
		viewMain.add(balance);
		viewMain.add(totalExpense);
		viewMain.add(totalIncome);
		viewMain.add(delete);
		viewMain.add(back);
		
		viewMain.add(table.panel);
		viewMain.add(background);
	}
	
	/*
	 * Function name: UI
	 * Description: It will show the viewing page frame.
	 */
	void UI() throws FileNotFoundException {
		
		date.setText(Integer.toString(calendar.get(Calendar.YEAR)) + "--"
				+ Integer.toString(calendar.get(Calendar.MONTH)+1));// magic number for calendar bug
		actionDetect();
		fill();
		statistic();
		
		
		viewMain.setVisible(true);
		condition = "open";
	}
	
	/*
	 * Function name: actionDetect
	 * Description: It will detect user input on the viewing page
	 */
	void actionDetect() {
		table.table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	        	statistic();
	        }
	    });
		
		export.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooser = new JFileChooser();
				int value = chooser.showSaveDialog(null);
				
				if (value == JFileChooser.APPROVE_OPTION) {
			        if(chooser.getSelectedFile().exists()) {
			        	table.export(chooser.getSelectedFile());
			        }
			    }
			}
		});
		
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.table.getSelectedRow()  != -1) {
					warn = new JFrame("Warning");
					warn.setSize(400, 200);
					
					warn.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // only main page supports close function
					warn.setLayout(null);
					
					JLabel msg = new JLabel("You want to delete this record ?");
					JButton no = new JButton("NO");
					JButton yes = new JButton("YES");
					msg.setBounds(20, 20, 200, 80);
					no.setBounds(10, 100, 80, 50);
					yes.setBounds(300, 100, 80, 50);
					
					ImageIcon warnIcon = new ImageIcon("resource\\warning.png");
					JLabel warnLabel = new JLabel();
					warnLabel.setIcon(warnIcon);
					warnLabel.setBounds(220, 10, 100, 80);
					
					warn.add(msg);
					warn.add(yes);
					warn.add(no);
					warn.add(warnLabel);
					
					no.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							warn.setVisible(false);
						}
					});
					yes.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								table.delete();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							table.model.removeRow(table.table.getSelectedRow());
							statistic();
							warn.setVisible(false);
						}
					});
					
					warn.setVisible(true);
				}
			}
		});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewMain.setVisible(false);
				condition = "back to main";
			}
		});
	}
	
	/*
	 * Function name: setRange
	 * Description: It will receive a date instance as the date filter
	 * for the JTable
	 */
	void setRange(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		table.setDate(calendar);
	}
	
	/*
	 * Function name: fill
	 * Description: This function will read database, apply the date filter,
	 * then fill the JTable
	 */
	void fill() throws FileNotFoundException {
		File myObj = new File("resource\\database.csv");
		Scanner scanner = new Scanner(myObj);

		while(scanner.hasNextLine()) {
			String []str = scanner.nextLine().split(",");
			if(str.length == 7) {
				Object []object = {str[2], str[3], str[4], str[5], str[6]};
				int j = calendar.get(Calendar.YEAR);
				int i = calendar.get(Calendar.MONTH) + 1;
				if(Integer.parseInt(str[0]) == j && Integer.parseInt(str[1]) == i){
					table.model.addRow(object);
				}
			}
			else {
				Object []object = {str[2], str[3], str[4], str[5]};
				int j = calendar.get(Calendar.YEAR);
				int i = calendar.get(Calendar.MONTH) + 1;
				if(Integer.parseInt(str[0]) == j && Integer.parseInt(str[1]) == i){
					table.model.addRow(object);
				}
			}			
		}
	}
	
	/*
	 * Function name: round
	 * Description: Round a double number to avoid it become too long
	 */
	double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	/*
	 * Function name: statistic
	 * Description: Calculate some data(balance, expense, income) of the table
	 */
	void statistic() {
		double sum, in = 0, out = 0;
		for(int i=0; i < table.table.getRowCount(); i++) {
			String temp = (String) table.table.getValueAt(i, 1);
			if(temp.charAt(0) == 'i') {
				in += Double.parseDouble((String) table.table.getValueAt(i, 3));
			}
			else {
				out += Double.parseDouble((String) table.table.getValueAt(i, 3));
			}
		}
		
		sum = in - out;
		// round result
		sum = round(sum, 5);
		in = round(in, 5);
		out = round(out, 5);
		
		balance.setText("Balance: " + Double.toString(sum));
		totalExpense.setText("Expense: " + Double.toString(out));
		totalIncome.setText("Income: " + Double.toString(in));
		
		balance.paintImmediately(balance.getVisibleRect());
		totalExpense.paintImmediately(totalExpense.getVisibleRect());
		totalIncome.paintImmediately(totalIncome.getVisibleRect());
	}
	
	
}
