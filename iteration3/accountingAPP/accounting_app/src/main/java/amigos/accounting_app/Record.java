package amigos.accounting_app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Record {
	int year, month, day;
	double amount;
	String event, type;
	String comment;
	
	Record(){
		year = -1;
		month = -1;
		day = -1;
		amount = -1;
		event = "invalid";
		type = "invalid";
		comment = " ";
	}
	
	boolean valid() {
		boolean result = true;
		if(year == -1 || month == -1 || day == -1 || amount == -1)
			result = false;
		if(event == "invalid" || type == "invalid")
			result = false;
		return result;
	}
	
    void write() throws IOException {
    	File file = new File("resource\\database.csv");
    	BufferedWriter output = new BufferedWriter(new FileWriter(file, true));
    	String str = year + "," + month + "," + day + "," + type + "," + event + "," + amount + "," + comment + "\n";
    	output.append(str);
    	output.close();
    }
}
