package com.signup.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",  // path to your feature files
    glue = "com.signup.step_definitions",  // step definition package & hooks
    plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports/cucumber.json"},
    monochrome = true,  // Makes the output more readable
    tags = ""  // No tags, this will run all scenarios
)

public class Runner {

}
