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

/**
 * 
 * Main function for the software. This function will load the data function system
 * if the user have records before and show the add page to the screen.
 * 
 * @author Yangzekun Gao, Maiqi Hou, Jingke Shi, Zhengyan Hu
 * @version 1.0 (Nov 30 2021)
 */
public class driver {

	/**
	 * 
	 * Main function for the software. This function will load the data function system
	 * if the user have records before and show the add page to the screen.
	 * @throws FileNotFoundException throw if file not found
	 * 
	 * @param args user are no expected to use arguments
	 */
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
