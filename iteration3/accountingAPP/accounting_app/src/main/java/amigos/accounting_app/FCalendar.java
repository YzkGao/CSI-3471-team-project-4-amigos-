package amigos.accounting_app;

import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jdesktop.swingx.JXDatePicker;


/**
 * 
 * Class FCalendar is a Calendar user interface which user can choose the day
 * of records they want to see the records.
 * 
 * @author Yangzekun Gao, Maiqi Hou, Jingke Shi, Zhengyan Hu
 * @version 1.0 (Nov 30 2021)
 */
public class FCalendar {

	JFrame frame;
    JPanel panel;
    JButton click;
    JXDatePicker picker;
    ImageIcon frameIcon;
    
	/**
	* Constructor for FCalendar which will create the User Interface
	* with Calendar, some icon.
	* @see org.jdesktop.swingx.JXDatePicker
	* 
	*/
    FCalendar(){
    	frame = new JFrame("Calendar");
    	panel = new JPanel();
    	picker = new JXDatePicker();
    	frameIcon = new ImageIcon("resource\\icon.jpg");
    }
    
	/**
	* Show the frame to the screen and get the time which user select
	* and store the date
	* 
	* void org.jdesktop.swingx.JXDatePicker.setDate(Date date)
	* Use the {@link #org.jdesktop.swingx.JXDatePicker.setDate(Date date) 
	* setDate} method.
	*/
    void UI() {
    	frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    	frame.setResizable(false);
    	frame.setIconImage(frameIcon.getImage());
        frame.setBounds(400, 400, 250, 100);

        picker.setDate(java.util.Calendar.getInstance().getTime());

        panel.add(picker);
        frame.getContentPane().add(panel);

        frame.setVisible(true);
    }
    
	/**
	* add the button to the panel
	* Use the {@link #Component java.awt.Container.add(Component comp) 
	* add} method.
	*/
    void addButton(JButton b) {
    	panel.add(b);
    }
}
