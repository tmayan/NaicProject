package org.naic.step_definitions;

import io.cucumber.java.en.*;
import org.naic.pages.LoginPage;
import org.naic.utility.Driver;

import static org.junit.Assert.assertEquals;

public class LoginStepDef {

    LoginPage loginPage=new LoginPage();
    @Given("user is at the login page")
    public void user_is_at_the_login_page() {
     loginPage.goTo();

    }
    @When("user enter the invalid password and credentials")
    public void user_enter_the_invalid_password_and_credentials() {
     loginPage.login();


    }


    @Then("user should able to see error message with {string}")
    public void userShouldAbleToSeeErrorMessageWith(String errorMessage) {
        assertEquals(errorMessage,loginPage.errorMessage.getText());
        Driver.getDriver().close();
    }
}
