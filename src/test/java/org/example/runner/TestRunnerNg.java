package org.example.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@HealthCheck",
        features = {"src/test/resources/features/"},
        glue = {"org/example/stepdef", "org/example/di"},
        plugin = {"pretty", "html:target/cucumber-report.html"})
public class TestRunnerNg extends AbstractTestNGCucumberTests {
}

