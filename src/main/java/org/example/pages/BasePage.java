package org.example.pages;

import com.google.inject.Inject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.guice.ScenarioScoped;
import lombok.Getter;
import org.example.fragments.Header;
import org.openqa.selenium.support.PageFactory;

@ScenarioScoped
@Getter
public abstract class BasePage {

    protected Header header;
    protected AppiumDriver driver;

    @Inject
    public BasePage(AppiumDriver driver, Header header) {
        this.driver = driver;
        this.header = header;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
