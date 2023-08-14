package org.example.stepdef;

import com.google.inject.Inject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.LogInPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LogInSteps {
    private final LogInPage logInPage;

    @Inject
    public LogInSteps(LogInPage logInPage) {
        this.logInPage = logInPage;
    }

    @Then("logged in successfully")
    public void loggedSuccessfully() {
        assertThat("Error message is wrong or was not displayed", logInPage.getHeader().currentScreen(), equalTo("Samples List"));
    }

    @When("^type (.*) username$")
    public void typeUsername(final String userName) {
        logInPage.typeUserName(userName);
    }

    @When("^type (.*) password$")
    public void typePassword(final String password) {
        logInPage.typePassword(password);
    }

    @When("^click on 'Log In' btn$")
    public void clickOnBtn() {
        logInPage.pressLoginBtn();
    }

    @Then("^verify that displayed (.+) user name$")
    public void verifyThatDisplayedUserName(final String expectedUser) {
        assertThat("Default user is wrong", logInPage.getDefaultUserName(), equalTo(expectedUser));
    }

    @Then("^window with (.+) error message displayed$")
    public void windowWithErrorMessageDisplayed(final String errorMessage) {
        assertThat("Error message is wrong or was not displayed", logInPage.getErrorMessage(), equalTo(errorMessage));
    }
}
