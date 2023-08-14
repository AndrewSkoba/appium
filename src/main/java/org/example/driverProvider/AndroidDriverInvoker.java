package org.example.driverProvider;

import com.google.inject.Inject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.guice.GuiceFactory;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.example.utils.PropertyHolder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_WAIT_ACTIVITY;
import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobileCapabilityType.*;
import static io.appium.java_client.service.local.AppiumServiceBuilder.BROADCAST_IP4_ADDRESS;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

@NoArgsConstructor
public class AndroidDriverInvoker extends DriverInvoker {

    @Override
    public void createDriver(PropertyHolder propertyHolder) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(DEVICE_NAME, propertyHolder.getDeviceName());
        capabilities.setCapability(PLATFORM_VERSION, propertyHolder.getPlatformVersion());
        capabilities.setCapability(PLATFORM_NAME, propertyHolder.getPlatformName());
        capabilities.setCapability(UDID, propertyHolder.getUdid());
        capabilities.setCapability(APP, new File(propertyHolder.getApp()).getAbsolutePath());
        capabilities.setCapability(AUTOMATION_NAME, ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(APP_PACKAGE, propertyHolder.getAppPackage());
        capabilities.setCapability(APP_WAIT_ACTIVITY, propertyHolder.getAppWaitActivity());
        capabilities.setCapability(FULL_RESET, propertyHolder.getFullReset());
        capabilities.setCapability(CLEAR_SYSTEM_FILES, propertyHolder.getClearSystemFiles());
        capabilities.setCapability(NO_RESET, propertyHolder.getNoReset());
        capabilities.setCapability(NEW_COMMAND_TIMEOUT, propertyHolder.getNewCommandTimeout());

        driver = new AndroidDriver(replaceHost(service.getUrl(), BROADCAST_IP4_ADDRESS, "127.0.0.1"), capabilities);
        driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
    }

    @SneakyThrows
    private URL replaceHost(URL source, String oldHost, String newHost) {
        return new URL(source.toString().replaceFirst(oldHost, newHost));
    }
}
