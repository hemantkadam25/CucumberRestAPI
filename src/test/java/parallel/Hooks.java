package parallel;

import java.io.IOException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Base {
	
	
	@Before()
	public void beforeHook(Scenario scenario) throws IOException {		
		initialization();		
		
	}
	
	@After()	
	public void afterHook(Scenario scenario) {
		System.out.println(getResponse().asString());	
		
		scenario.log("**** Scenario = "+scenario.getName()+" has been -->> "+scenario.getStatus().toString()+ " *****");
		
		getLog().info("**** Scenario \""+scenario.getName()+ "\" has been -->>  "+scenario.getStatus()+" ****");
	}
	
	
}
