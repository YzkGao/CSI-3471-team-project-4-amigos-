/*
 * Team: 4 amigos
 * Members: Maiqi Hou, Jingke Shi, Yangzekun Gao, Zhengyan Hu
 * 
 * File description: This function provides the record instance
 */
package amigos.accounting_app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Each Input from the User will keep as a Record type and store into database
 * 
 * @author Yangzekun Gao, Maiqi Hou, Jingke Shi, Zhengyan Hu
 * @version 1.0 (Nov 30 2021)
 */
public class Record {
	int year, month, day;
	double amount;
	String event, type;
	String comment;
	
	/**
	 * Default constructor for Record which will set each value to Default value
	 * 
	 */
	Record(){
		year = -1;
		month = -1;
		day = -1;
		amount = -1;
		event = "invalid";
		type = "invalid";
		comment = " ";
	}
	
	/*
	 * Function name: valid
	 * Description: Return true if the record is valid, otherwise return false
	 */
	
	/**
	 * The function check if the record is a valid record
	 * For example, year,month,day,amount need to be > 0,
	 * event and type cannot be invalid
	 * 
	 * @return boolean return true if record is a valid record
	 */
	boolean valid() {
		boolean result = true;
		if(year == -1 || month == -1 || day == -1 || amount == -1)
			result = false;
		if(event == "invalid" || type == "invalid")
			result = false;
		return result;
	}
	
	/*
	 * Function name: write
	 * Description: Write record to database
	 */
	
	/**
	 * Function that will store the record to database file.
	 * Open file, export the record as a String and
	 *  append String to the database file.
	 * 
	 * @return boolean return true if record is a valid record
	 * @throws IOException throw if any IO exception occur
	 * 
	 */
    void write() throws IOException {
    	File file = new File("resource\\database.csv");
    	BufferedWriter output = new BufferedWriter(new FileWriter(file, true));
    	String str = year + "," + month + "," + day + "," + type + "," + event + "," + amount + "," + comment + "\n";
    	output.append(str);
    	output.close();
    }
}
