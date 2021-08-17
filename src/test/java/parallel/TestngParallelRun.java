package parallel;


import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

		features = { "src/test/resources/parallel" },
		glue =		{ "parallel" },  //glue = "stepDefinations", 		
		tags = "@Sanity and not @Skip",
		monochrome = true, 
		//publish = true, 
		dryRun = false,  
		
		plugin = {
				//"pretty", "message",
				"progress",				
			//	"pretty:target/Reports/Cucumber.txt",				
				"html:target/Reports/Cucumber.html", 
				"json:target/Reports/Cucumber.json", 
			//	"junit:target/Reports/Cucumber.xml",
			//	"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",				
			//	"timeline:target/Reports/ThreadReports/",
			//	"rerun:target/failedScenario/failedScenarioReRun.txt",
            //  "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",				
				
				}
				

)

public class TestngParallelRun extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
	

}
