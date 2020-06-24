package pages;

import com.aventstack.extentreports.ExtentTest;
import core.CreateReport;
import core.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login extends WebDriverFactory {

    CreateReport createReport;

    @FindBy(how = How.ID, using = "txtUsername")
    private WebElement edt_Username;
    @FindBy(how = How.ID, using = "txtPassword")
    private WebElement edt_Password;
    @FindBy(how = How.ID, using = "btnLogin")
    private WebElement btn_Login;

    public Login(CreateReport createReport) {
        this.createReport = createReport;
    }

    /**
     * Fills the username field.
     * @param username to log in to the app.
     * @return {@link Login}
     */
    public Login enterUsername(String username){
        try {
            edt_Username.clear();
            edt_Username.sendKeys(username);
            createReport.test.info("username field filled with username: "+username);
        }catch(Exception e){
            final String ERROR_MESSAGE = "there was a problem filling username";
            throw new Error(ERROR_MESSAGE,e);
        }
        return this;
    }

    /**
     * Fills the password field.
     * @param password to log in along with an specific user.
     * @return {@link Login}
     */
    public Login enterPassword(String password){
        try {
            edt_Password.clear();
            edt_Password.sendKeys(password);
            createReport.test.info("password field fillec with password: "+password);
        }catch(Exception e){
            final String ERROR_MESSAGE = "there was a problem filling password";
            throw new Error(ERROR_MESSAGE,e);
        }
        return this;
    }

    /**
     * Clicks on log in button.
     */
    public void clickLoginButton(){
        try {
            btn_Login.click();
            createReport.test.info("click on button login.");
        }catch(Exception e){
            final String ERROR_MESSAGE = "there was a problem clicking login button";
            throw new Error(ERROR_MESSAGE,e);
        }
    }

}
