package amigos.accounting_app;

import java.io.File;
import java.io.IOException;

public class driver {

	public static void main(String[] args) {
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
		}
	}

}
