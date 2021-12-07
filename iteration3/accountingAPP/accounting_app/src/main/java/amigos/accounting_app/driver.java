/*
 * Team: 4 amigos
 * Members: Maiqi Hou, Jingke Shi, Yangzekun Gao, Zhengyan Hu
 * 
 * File description: This is the driver of the application with the main function.
 * It will generate the database and call the UI function of the main menu page
 */

package amigos.accounting_app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class driver {

	public static void main(String[] args) throws FileNotFoundException {
		
		File database = new File("resource\\database.csv");
		if(!database.exists()) {
			try {
				database.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		mainPage mainpage = new mainPage();
		mainpage.UI();
		
		while(mainpage.condition != "end") {
			if(mainpage.addpage.condition == "back to main") {
				mainpage = new mainPage();
				mainpage.UI();
			}
			
			if(mainpage.viewpage.condition == "back to main") {
				mainpage = new mainPage();
				mainpage.UI();
			}
		}
		
		System.exit(0);
	}

}
