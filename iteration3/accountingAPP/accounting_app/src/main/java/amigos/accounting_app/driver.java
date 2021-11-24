package amigos.accounting_app;

public class driver {

	public static void main(String[] args) {
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
