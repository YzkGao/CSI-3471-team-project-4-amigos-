package amigos.accounting_app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.util.Date;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     * @throws FileNotFoundException 
     */
    @Test
    public void testMain() throws FileNotFoundException
    {
        mainPage mainpage = new mainPage();
        mainpage.UI();
        
    }
    
    
    @Test
    public void testAdd() {
    	addPage addpage = new addPage();
    	addpage.UI();
    }
    
    @Test
    public void testvalidDoulbe() {
    	addPage addpage = new addPage();
    	addpage.amount = "abc";
    	
    	if(addpage.validDoulbe()) {
    		fail("it should return false");
    	}
    	
    	addpage.amount = "123.321";
    	
    	if(!addpage.validDoulbe()) {
    		fail("it should return true");
    	}
    }
    
    @Test
    public void testView() throws FileNotFoundException {
    	viewPage viewpage = new viewPage();
    	viewpage.setRange(new Date());
    	viewpage.UI();
    }
    
    @Test
    public void testRound() throws FileNotFoundException {
    	viewPage viewpage = new viewPage();
		double num = 2.123456;
	    num = viewpage.round(num, 2);
		if(num != 2.12) {
			fail();
		}
    }
    
}
