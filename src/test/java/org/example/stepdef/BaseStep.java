package org.example.stepdef;


import com.google.inject.Inject;
import io.cucumber.java.After;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.driverProvider.DriverInvoker;

@NoArgsConstructor
@Log4j2
public class BaseStep {

    private DriverInvoker driver;

    @Inject
    public BaseStep(DriverInvoker driver) {
        this.driver = driver;
    }

    @After
    public void afterTest() {
        driver.stopSession();
        log.info("Session stopped");
    }
}
