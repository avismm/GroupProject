package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features ="src/test/resources/features",
        glue = "steps",
        dryRun = false,
        tags ="@terminate",


        //tags will identify the scenarios in a group and will execute the scenarios having these tags
        //We use 'and' and 'or' keywords to execute based on conditions
        //no execution will occur because there is no scenario that has both the tags specified
        //tags ="@ali and @nafisa"

        plugin = {"pretty"}
        //generating the test report
        //pretty is responsible for printing the step definition in the console during local execution
        //In your framework, all reports should be generated under target folder. Target folder is created by default in all projects.
        //We will generate html report in target folder
        //rerun plugin will create a failed.txt under the target folder for all failed test cases.
     // plugin = {"pretty", "html:target/cucumber.html","json:target/cucumber.json","rerun:target/failed.txt"}

)

public class RunnerClass {

}
