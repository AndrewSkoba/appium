package org.example.fragments;

import com.google.inject.Inject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
@ScenarioScoped
public class Header {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Back']")
    private WebElement backBtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Samples List']")
    private WebElement screenName;

    @Inject
    public Header(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String currentScreen() {
        return screenName.getText();
    }

    public void clickOnBackBtn() {
        backBtn.click();
    }

}
