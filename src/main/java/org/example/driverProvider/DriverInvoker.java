package org.example.driverProvider;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import lombok.NoArgsConstructor;
import org.example.utils.PropertyHolder;


@NoArgsConstructor
public abstract class DriverInvoker {

    protected AppiumDriver driver;
    protected AppiumDriverLocalService service;

    protected void startService() {
        service = AppiumDriverLocalService.buildService((new AppiumServiceBuilder()).usingAnyFreePort());
        service.start();
    }

    public AppiumDriver getDriver(PropertyHolder propertyHolder) {
        if (null == driver) {
            startService();
            createDriver(propertyHolder);
        }
        return driver;
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public void stopSession() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        if (service != null && service.isRunning()) {
            service.stop();
        }
    }

    protected abstract void createDriver(PropertyHolder propertyHolder);
}
