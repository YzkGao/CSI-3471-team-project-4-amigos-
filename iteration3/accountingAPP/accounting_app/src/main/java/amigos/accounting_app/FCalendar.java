package amigos.accounting_app;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.text.SimpleDateFormat;

import org.jdesktop.swingx.JXDatePicker;


public class FCalendar {

	JFrame frame;
    JPanel panel;
    JButton click;
    JXDatePicker picker;
    
    FCalendar(){
    	frame = new JFrame("Calendar");
    	panel = new JPanel();
    	picker = new JXDatePicker();
    }
    
    void UI() {
    	frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setBounds(400, 400, 250, 100);

        picker.setDate(java.util.Calendar.getInstance().getTime());

        panel.add(picker);
        frame.getContentPane().add(panel);

        frame.setVisible(true);
    }
    
    void addButton(JButton b) {
    	panel.add(b);
    }
}
