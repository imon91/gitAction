package testRunner;

import io.cucumber.testng.*;

@CucumberOptions(
        features = "src/test/resources/features/authentication.feature",
        glue = "stepDefinitions",
        plugin = {
                "pretty",
                "json:build/cucumber-report/cucumber.json",
                "html:build/cucumber-report/cucumber.html",
                "junit:build/cucumber-report/cucumber.xml"})
public class TestRunner extends AbstractTestNGCucumberTests{
}
