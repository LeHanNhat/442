package Lab5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Client_ProductTest {

	 @Test
	    public void FemaleCityDwellerUnder35() {
	        Client_Product cp = new Client_Product();
	        cp.setInput("Female", "Yes", 34);
	        assertEquals("W X and Y", cp.assignProduct());
	    }
	    
	    @Test
	    public void FemaleCityDweller35to65() {
	        Client_Product cp = new Client_Product();
	        cp.setInput("Female", "Yes", 45);
	        assertEquals("X and Y", cp.assignProduct());
	    }
	    
	    @Test
	    public void FemaleCityDwellerOver65() {
	        Client_Product cp = new Client_Product();
	        cp.setInput("Female", "Yes", 70);
	        assertEquals("Only Y", cp.assignProduct());
	    }
	    
	    @Test
	    public void FemaleNonDwellerUnder35() {
	        Client_Product cp = new Client_Product();
	        cp.setInput("Female", "No", 25);
	        assertEquals("W and X", cp.assignProduct());
	    }
	    
	    @Test
	    public void FemaleNonDweller35to65() {
	        Client_Product cp = new Client_Product();
	        cp.setInput("Female", "No", 40);
	        assertEquals("Only X", cp.assignProduct());
	    }
	    
	    @Test
	    public void MaleCityDwellerAnyAge() {
	        Client_Product cp = new Client_Product();
	        cp.setInput("Male", "Yes", 45);
	        assertEquals("Only X", cp.assignProduct());
	    }
	    
	    @Test
	    public void MaleNonDwellerUnder35() {
	        Client_Product cp = new Client_Product();
	        cp.setInput("Male", "No", 25);
	        assertEquals("Only X", cp.assignProduct());
	    }
	    
	    @Test
	    public void MaleNonDweller35to65() {
	        Client_Product cp = new Client_Product();
	        cp.setInput("Male", "No", 45);
	        assertEquals("W and Z", cp.assignProduct());
	    }

}
