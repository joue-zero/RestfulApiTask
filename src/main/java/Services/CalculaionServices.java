package Services;

import javax.ejb.Stateless;

import Entities.Calculation;

@Stateless
public class CalculaionServices {

	
	public int calculate(Calculation calculation) 
	{
	    String operation = calculation.getOperationS();
	    
	    if ("+".equals(operation)) {
	        return calculation.getNumber1() + calculation.getNumber2();
	    } else if ("-".equals(operation)) {
	        return calculation.getNumber1() - calculation.getNumber2();
	    } else if ("*".equals(operation)) {
	        return calculation.getNumber1() * calculation.getNumber2();
	    } else if ("/".equals(operation)) {
	        return calculation.getNumber1() / calculation.getNumber2();
	    } else {
	        return -1;
	    }
	}
	
}
