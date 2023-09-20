package org.example.di;

import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import io.appium.java_client.AppiumDriver;
import io.cucumber.guice.ScenarioScoped;
import org.example.driverProvider.*;
import com.google.inject.AbstractModule;
import org.example.utils.PropertyHolder;

public class DriverModule extends AbstractModule {

    private final  PropertyHolder propertyHolder = new PropertyHolder();

    @Override
    protected void configure() {
        Class<? extends DriverInvoker> clazz =  DriverTypes.getDriverInvoker(propertyHolder.getPlatformName()).getClass();
        bind(DriverInvoker.class)
                .to(clazz)
                .in(Scopes.SINGLETON);
    }

    @Provides
    @ScenarioScoped
    @Inject
    public AppiumDriver getDriver(DriverInvoker driverManager, PropertyHolder propertyHolder) {
        return driverManager.getDriver(propertyHolder);
    }
}