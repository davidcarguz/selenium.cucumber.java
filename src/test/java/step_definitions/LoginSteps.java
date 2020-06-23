package step_definitions;

import io.cucumber.java8.En;
import org.junit.Assert;
import pages.Home;
import pages.Login;

public class LoginSteps implements En {

    public LoginSteps(Login login, Home home) {
        When("User enters username {string} and password {string}", (String username, String password) -> {
            login.initialize();
            login.enterUsername(username)
                    .enterPassword(password)
                    .clickLoginButton();
        });

        Then("User validates correct login", () -> {
            home.initialize();
            Assert.assertTrue(home.checkDashboardIsPresent());
        });
    }
}
