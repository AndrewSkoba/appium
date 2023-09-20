package org.example.stepdef;


import com.google.inject.Inject;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.driverProvider.DriverInvoker;
import org.openqa.selenium.TakesScreenshot;

import static org.openqa.selenium.OutputType.BYTES;

@NoArgsConstructor
@Log4j2
public class BaseStep {

    private DriverInvoker driver;

    @Inject
    public BaseStep(DriverInvoker driver) {
        this.driver = driver;
    }

    @After
    public void afterTest(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] bytes = ((TakesScreenshot) driver.getDriver()).getScreenshotAs(BYTES);
            scenario.attach(bytes, "image/png", "image");
        }
        driver.stopSession();
        log.info("Session stopped");
    }
}
