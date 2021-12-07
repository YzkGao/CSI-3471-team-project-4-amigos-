/*
 * Team: 4 amigos

 * Members: Maiqi Hou, Jingke Shi, Yangzekun Gao, Zhengyan Hu
 * 
 * File description: This function creates the adding page.
 */
package amigos.accounting_app;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 
 * class addPage Create a GUI for the add Page and input from user action
 * with JFrame, JButton and ActionListener. Store the input to record and 
 * save it at the local system
 * 
 * @see javax.swing.JFrame
 * @see java.awt.event.ActionListener
 * 
 * 
 * @author Yangzekun Gao, Maiqi Hou, Jingke Shi, Zhengyan Hu
 * @version 1.0 (Nov 30 2021)
 */
public class addPage {
	JFrame addMain;
	JLabel background;
	ImageIcon backgroundIcon, frameIcon;
	
	JButton food, shopping, transportation, entertainment, travel, study;
	JButton salary, financialServer, other;
	JButton back, create;
	
	JButton expense, income;
	JButton edit;
	
	JLabel eventIndicator, typeIndicator, amountIndicator;
	
	JLabel year, month, day;
	JTextField yearGeter, monthGeter, dayGeter;
	
	JLabel comment;
	JTextField commentGeter;
	
	JButton date;
	
	// indicate the condition of the frame
	String condition = new String();
	
	// record
	Record record;
	
	// calendar
	FCalendar fcalendar;
	JButton click;     // for add a date
	
	// error for invalid record
	JLabel error;
	
	// for amount input frame
	JFrame input;
	JButton one, two, three, four, five, six, seven, eight, nine, zero, dot;
	JButton delete, finish, cancel;
	JLabel inputBackground;
	ImageIcon inputBackgroundIcon;
	String amount;
	JLabel showAmount;
	// for amount input frame
	
	/*
	 * Function name: addPage
	 * Description: The default constructor
	 */
	
	/**
	* Constructor for addPage which will create the User Interface
	* with JFrame Table and button for the records
	* 
	* @see javax.swing.JFrame;
	*/
	addPage(){
		// set record
		record = new Record();
		
		// set frame
		addMain = new JFrame("adding");
		addMain.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // only main page supports close function
		addMain.setLayout(null);
		//addMain.setResizable(false);
		addMain.setSize(700, 900);
				
		// set frame icon
		frameIcon = new ImageIcon("resource\\icon.jpg");
		addMain.setIconImage(frameIcon.getImage());
				
		// set background
		backgroundIcon = new ImageIcon("resource\\background.png");
		background = new JLabel();
		background.setIcon(backgroundIcon);
		background.setBounds(0, 0, 700, 900);
		
		// set event buttons
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
		
		// set event indicator
		eventIndicator = new JLabel("Event: ?");
		eventIndicator.setBounds(20, 140, 500, 90);
		eventIndicator.setFont(new Font("Serif", Font.PLAIN, 20));
		
		// set type buttons
		expense = new JButton("expense");
		expense.setBounds(20, 220, 90, 50);
		income = new JButton("income");
		income.setBounds(140, 220, 90, 50);
		
		// set type indicator
		typeIndicator = new JLabel("Type: ?");
		typeIndicator.setBounds(20, 260, 500, 90);
		typeIndicator.setFont(new Font("Serif", Font.PLAIN, 20));
		
		// set amount indicator
		amountIndicator = new JLabel("$: ?");
		amountIndicator.setBounds(20, 390, 500, 90);
		amountIndicator.setFont(new Font("Serif", Font.PLAIN, 20));
		
		// set edit button
		edit = new JButton("edit");
		edit.setBounds(20, 340, 70, 50);
		
		// set data getter
		year = new JLabel("Year:");
		year.setFont(new Font("Serif", Font.PLAIN, 20));
		month = new JLabel("Mounth:");
		month.setFont(new Font("Serif", Font.PLAIN, 20));
		day = new JLabel("Day:");
		day.setFont(new Font("Serif", Font.PLAIN, 20));
		yearGeter = new JTextField();
		monthGeter = new JTextField();
		dayGeter = new JTextField();
		year.setBounds(20, 430, 80, 90);
		yearGeter.setBounds(80, 460, 80, 40);
		month.setBounds(180, 430, 80, 90);
		monthGeter.setBounds(260, 460, 80, 40);
		day.setBounds(360, 430, 80, 90);
		dayGeter.setBounds(430, 460, 80, 40);
		yearGeter.setEditable(false);
		dayGeter.setEditable(false);
		monthGeter.setEditable(false);
		
		// set date button
		date = new JButton("set date");
		date.setBounds(530, 460, 90, 40);
		
		
		// set create button
		create = new JButton("create");
		create.setFont(new Font("Serif", Font.PLAIN, 14));
		create.setBounds(600, 800, 70, 50);
		
		// set back button
		back = new JButton("back");
		back.setFont(new Font("Serif", Font.PLAIN, 14));
		back.setBounds(10, 800, 70, 50);
		
		// set comment
		comment = new JLabel("Comment:");
		comment.setFont(new Font("Serif", Font.PLAIN, 20));
		commentGeter = new JTextField();
		comment.setBounds(20, 550, 80, 90);
		commentGeter.setBounds(120, 580, 500, 30);
		
		// set error
		error = new JLabel("");
		error.setBounds(20, 700, 600, 50);
		error.setFont(new Font("Serif", Font.PLAIN, 20));
		
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
		
		addMain.add(expense);
		addMain.add(income);
		
		addMain.add(edit);
		
		addMain.add(eventIndicator);
		addMain.add(typeIndicator);
		addMain.add(amountIndicator);
		
		addMain.add(year);
		addMain.add(month);
		addMain.add(day);
		addMain.add(yearGeter);
		addMain.add(monthGeter);
		addMain.add(dayGeter);
		addMain.add(date);
		
		addMain.add(comment);
		addMain.add(commentGeter);
		
		addMain.add(back);
		addMain.add(create);
		addMain.add(error);
		addMain.add(background);
		
	}
	
	/*
	 * Function name: UI
	 * Description: It will show the adding page frame.
	 */
	
	/**
	* Graphical user interface creator. When add button was click 
	* system will show add Page
	* 
	* Use the {@link #actionDetect() actionDetect} method
	*/
	void UI() {
		actionDetect();
		addMain.setVisible(true);
		
		// set condition
		condition = "open";
	}
	
	/*
	 * Function name: actionDetect
	 * Description: It will detect user input on the adding page
	 */
	
	/**
	* Detect the action of User and store each action to class variable
	* and may show a new page for user to click to input the nubmer of amount
	* 
	* @see java.awt.event.ActionListener
	* @throws IOException throw if any exception occur
	*/
	void actionDetect() {
		food.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventIndicator.setText("Event: food");
				record.event = "food";
			}
		});
		shopping.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventIndicator.setText("Event: shopping");
				record.event = "shopping";
			}
		});
		transportation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventIndicator.setText("Event: transportation");
				record.event = "transportation";
			}
		});
		entertainment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventIndicator.setText("Event: entertainment");
				record.event = "entertainment";
			}
		});
		travel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventIndicator.setText("Event: travel");
				record.event = "travel";
			}
		});
		study.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventIndicator.setText("Event: study");
				record.event = "study";
			}
		});
		salary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventIndicator.setText("Event: salary");
				record.event = "salary";
			}
		});
		financialServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventIndicator.setText("Event: financial server");
				record.event = "financial server";
			}
		});
		other.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eventIndicator.setText("Event: other");
				record.event = "other";
			}
		});
		
		expense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeIndicator.setText("Type: expense");
				record.type = "expense";
			}
		});
		income.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeIndicator.setText("Type: income");
				record.type = "income";
			}
		});
		
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input = new JFrame("amount input");
				input.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // dosen't support close button
				inputBackgroundIcon = new ImageIcon("resource\\background.png");
				inputBackground = new JLabel();
				inputBackground.setIcon(inputBackgroundIcon);
				inputBackground.setBounds(0, 0, 350, 500);
				input.setLayout(null);
				input.setResizable(false);
				input.setSize(350, 500);
				
				one = new JButton("one");
				two = new JButton("two");
				three = new JButton("three");
				four = new JButton("four");
				five = new JButton("five");
				six = new JButton("six");
				seven = new JButton("seven");
				eight = new JButton("eight");
				nine = new JButton("nine");
				zero = new JButton("zero");
				dot = new JButton("dot");
				
				one.setBounds(10, 60, 80, 50);
				two.setBounds(120, 60, 80, 50);
				three.setBounds(220, 60, 80, 50);
				four.setBounds(10, 160, 80, 50);
				five.setBounds(120, 160, 80, 50);
				six.setBounds(220, 160, 80, 50);
				seven.setBounds(10, 260, 80, 50);
				eight.setBounds(120, 260, 80, 50);
				nine.setBounds(220, 260, 80, 50);
				zero.setBounds(10, 340, 80, 50);
				dot.setBounds(120, 340, 80, 50);
				
				delete = new JButton("delete");
				finish = new JButton("finish");
				cancel = new JButton("cancel");
				
				cancel.setBounds(10, 400, 80, 50);
				finish.setBounds(220, 400, 80, 50);
				delete.setBounds(220, 340, 80, 50);
				
				amount = new String("");
				showAmount = new JLabel(amount);
				
				showAmount.setBounds(10, 10, 350, 70);
				showAmount.setFont(new Font("Serif", Font.PLAIN, 20));
				
				input.add(one);
				input.add(two);
				input.add(three);
				input.add(four);
				input.add(five);
				input.add(six);
				input.add(seven);
				input.add(eight);
				input.add(nine);
				input.add(zero);
				input.add(dot);
				input.add(delete);
				input.add(cancel);
				input.add(finish);
				input.add(showAmount);
				input.add(inputBackground);
				
				inputActionDetect();
				input.setVisible(true);
			}
		});
		
		date.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				fcalendar = new FCalendar();
				click  = new JButton("add");
				fcalendar.addButton(click);
				fcalendar.UI();
				
				click.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {				
						Date date = fcalendar.picker.getDate();
						Calendar calendar = Calendar.getInstance();
						calendar.setTime(date);
						record.year = calendar.get(Calendar.YEAR);
						record.month = calendar.get(Calendar.MONTH)+1; // magic number for calendar bug
						record.day = calendar.get(Calendar.DAY_OF_MONTH);
						
						yearGeter.setText(Integer.toString(record.year));
						monthGeter.setText(Integer.toString(record.month));
						dayGeter.setText(Integer.toString(record.day));
						
						fcalendar.frame.setVisible(false);
					}
				});
			}
		});
		
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMain.setVisible(false);
				condition = "back to main";
			}
		});
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				record.comment = commentGeter.getText();
				
				if(record.valid()) {
					addMain.setVisible(false);
					condition = "back to main";
					try {
						record.write();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					error.setText("Please enter correct event/type/amount/date");
				}
			}
		});
	}
	
	/**
	 * This Function detect the action from user
	 * which perform like a calculator, each time people
	 * click number will be stored. 
	 * 
	 * @see java.awt.event.ActionListener
	 */
	void inputActionDetect() {
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setVisible(false);
				input.dispose();
			}
		});
		one.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amount += "1";
				showAmount.setText(amount);
			}
		});
		two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amount += "2";
				showAmount.setText(amount);
			}
		});
		three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amount += "3";
				showAmount.setText(amount);
			}
		});
		four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amount += "4";
				showAmount.setText(amount);
			}
		});
		five.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amount += "5";
				showAmount.setText(amount);
			}
		});
		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amount += "6";
				showAmount.setText(amount);
			}
		});
		seven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amount += "7";
				showAmount.setText(amount);
			}
		});
		eight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amount += "8";
				showAmount.setText(amount);
			}
		});
		nine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amount += "9";
				showAmount.setText(amount);
			}
		});
		zero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amount += "0";
				showAmount.setText(amount);
			}
		});
		dot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amount += ".";
				showAmount.setText(amount);
			}
		});
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(amount.length() > 1) {
					amount = amount.substring(0, amount.length()-1);
					showAmount.setText(amount);
				}
				else if(amount.length() == 1){
					amount = "";
					showAmount.setText(amount);
				}
			}
		});
		finish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validDoulbe()) {
					amountIndicator.setText("$: " + amount);
					record.amount = Double.parseDouble(amount);
				}
				input.setVisible(false);
			}
		});
	}
	
	/**
	 * The function return the pattern of float number
	 * for the string to check the by regular  expression 
	 * @return boolean if amount match to double pattern, function return true, else false
	 * @see java.util.regex.Pattern
	 */
	boolean validDoulbe() {
		Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
		return pattern.matcher(amount).matches();
	}
}
