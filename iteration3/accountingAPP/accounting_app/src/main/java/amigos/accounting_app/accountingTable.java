/*
 * Team: 4 amigos

 * Members: Maiqi Hou, Jingke Shi, Yangzekun Gao, Zhengyan Hu
 * 
 * File description: This function is a container of a bunch of records
 */
package amigos.accounting_app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.coderazzi.filters.gui.AutoChoices;
import net.coderazzi.filters.gui.TableFilterHeader;

/**
 * 
 * class accountingTable collect a bunch of "records"
 * and contains the function to deal with "records"
 * 
 * @see amigos.accounting_app.Record
 * 
 * @author Yangzekun Gao, Maiqi Hou, Jingke Shi, Zhengyan Hu
 * @version 1.0 (Nov 30 2021)
 */
public class accountingTable {
	String []column = {"Day", "Type", "Event", "Amount","Comment"};
	
	String eventFilter, typeFilter;
	Calendar dateFilter;
	
	
	DefaultTableModel model;
	JTable table;
	TableFilterHeader filterHeader;
	JScrollPane panel;
	
	File database;
	
	
	/**
	* Constructor for accountingTable which will initialize the 
	* Java Swing Table for the records
	* 
	* @see javax.swing.table.DefaultTableModel
	*/
	accountingTable() throws FileNotFoundException{
		model = new DefaultTableModel(column, 0) {
		    @Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		table = new JTable(model);
		filterHeader = new TableFilterHeader(table, AutoChoices.ENABLED);
		panel = new JScrollPane (table);
		panel.setBounds(0, 150, 884, 500);
		dateFilter = Calendar.getInstance();
		
		table.getColumnModel().getColumn(4).setPreferredWidth(500);
	}
	

	/**
	 * Export Module implementation; Traverse the current table and
	 * Write records to a given file. Open the file and print each 
	 * record to the file.
	 * @param file provide the file to be output
	 * @throws IOException throw if any io exception occur
	 */
	void export(File file) {

		double sum, in = 0, out = 0;
		for(int i=0; i < table.getRowCount(); i++) {
			String temp = (String) table.getValueAt(i, 1);
			if(temp.charAt(0) == 'i') {
				in += Double.parseDouble((String) table.getValueAt(i, 3));
			}
			else {
				out += Double.parseDouble((String) table.getValueAt(i, 3));
			}
		}
		sum = in - out;
		PrintWriter pw = null;

		  try {
		     FileWriter fw = new FileWriter(file, true);
		     pw = new PrintWriter(fw);
		     String year = Integer.toString(dateFilter.get(Calendar.YEAR));
		     String month = Integer.toString(dateFilter.get(Calendar.MONTH)+1);
		     String day = Integer.toString(dateFilter.get(Calendar.DAY_OF_MONTH));
		     String date = month + "/" + day + "/" + year + "\n";
		     String stat = "Balance = " + sum + ", expense = " + out + ", income = " + in + "\n";
		     pw.print(date + stat);
		     for(int i=0 ;i < table.getRowCount(); i++) {
		    	 for(int j=0 ;j < table.getColumnCount(); j++) {
		    		 pw.print(table.getValueAt(i, j) + ", ");
		    	 }
		    	 pw.print("\n");
		     }
		     
		  } catch (IOException e1) {
		     e1.printStackTrace();
		  } finally {
		     if (pw != null) {
		        pw.close();
		     }
		  }
	}
	

	/**
	 * provide with Calendar, set the filter for the records
	 * according to the range of given Calendar. Change the 
	 * dateFilter to c
	 * 
	 * @param c provide the Calendar which can set a day filter 
	 */
	void setDate(Calendar c) {
		dateFilter = c;
	}
	
	/*
	 * Function name: match
	 * Description: Return true if the record meets all filters
	 */
	
	/**
	 * Provide with two records. One is string type, another is 
	 * Record type. Function will parse the record to String type
	 * and compare the string to match each other.
	 * 
	 * @param record The first record to be match 
	 * @param str The second record to be match in String Type
	 * @return boolean 
	 * @see java.lang.String
	 */
	boolean match(Record record, String str) {
		String str2;
		if(str.split(",").length == 7) {
			str2 = record.year + "," + record.month + "," + record.day + "," + record.type
					+ "," + record.event + "," + record.amount + "," + record.comment;
		}
		else {
			str2 = record.year + "," + record.month + "," + record.day + "," + record.type
					+ "," + record.event + "," + record.amount;
		}
		
		if(str.contains(str2)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	/**
	 * This Function delete the current select record on the table
	 * We will delete the previous file and initialize a new file to
	 * store the new data without the select row 
	 * @throws IOException throw if any exception occur
	 */
	void delete() throws IOException {
		Record record = new Record();
		int ndx = table.getSelectedRow();
		record.year = dateFilter.get(Calendar.YEAR);
		record.month = dateFilter.get(Calendar.MONTH) + 1;
		record.day = Integer.parseInt((String) table.getValueAt(ndx, 0));
		record.type = (String) table.getValueAt(ndx, 1);
		record.event = (String) table.getValueAt(ndx, 2);
		record.amount = Double.parseDouble((String) table.getValueAt(ndx, 3));
		record.comment = (String) table.getValueAt(ndx, 4);
		
		File inputFile = new File("resource\\database.csv");
		File tempFile = new File("resource\\myTempFile.csv");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
		
		String currentLine;
		
		while((currentLine = reader.readLine()) != null) {
		    // trim newline when comparing with lineToRemove
		    String trimmedLine = currentLine.trim();
		    if(match(record, currentLine)) continue;
		    writer.write(currentLine + System.getProperty("line.separator"));
		}
		writer.close(); 
		reader.close();
		clearFile();
		rewrite();
	}
	
	/*
	 * Function name: clearFile
	 * Description: To empty a file, it is a part of deleting records
	 */
	
	/**
	 * This Function is part of delete function which will 
	 * clear the old data file
	 * 
	 * @throws IOException throw if any exception occur
	 */
	void clearFile() throws IOException {
		FileWriter fwOb = new FileWriter("resource\\database.csv", false); 
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
	}
	
	/*
	 * Function name: rewrite
	 * Description: Rewrite the database, it is a part of deleting records
	 */
	
	/**
	 * This Function is part of delete function which will 
	 * write the new data to new data file
	 * 
	 * @throws IOException throw if any exception occur
	 */
	void rewrite() {
		 try {

	            FileReader fr = new FileReader("resource\\myTempFile.csv");
	            FileWriter fw = new FileWriter("resource\\database.csv");
	 
	            String str = "";
	 
	            int i;
	 
	            while ((i = fr.read()) != -1) {
	                str += (char)i;
	            }
	 
	            //System.out.println(str);
	 
	            fw.write(str);
	            fr.close();
	            fw.close();
	 
	            System.out.println(
	                "File reading and writing both done");
	        }
	 
	        catch (IOException e) {

	            System.out.println(
	                "There are some IOException");
	        }
		 }
		
}
