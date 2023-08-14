package org.example.pages;

import com.google.inject.Inject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.cucumber.guice.ScenarioScoped;
import lombok.Getter;
import lombok.Setter;
import org.example.fragments.Header;
import org.openqa.selenium.WebElement;

@ScenarioScoped
@Getter
@Setter
public class LogInPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='LOG IN']")
    private WebElement loginBtn;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@content-desc, \"username\")]")
    private WebElement userNameField;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@content-desc, \"password\")]")
    private WebElement passwordField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/message\")")
    private WebElement errorMessage;

    @Inject
    public LogInPage(AppiumDriver driver, Header header) {
        super(driver, header);
    }

    public void typeUserName(String userName) {
        userNameField.sendKeys(userName);
    }

    public void typePassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void pressLoginBtn() {
        loginBtn.click();
    }

    public String getDefaultUserName() {
        return userNameField.getText();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
