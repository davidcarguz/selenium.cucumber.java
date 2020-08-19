package pages;

import core.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Home ui methods.
 */
public class Home extends WebDriverFactory {

    @FindBy(how = How.TAG_NAME, using = "h1")
    private WebElement lbl_Dashboard;

    /**
     * Checks if the Dashboard element is displayed.
     * @return True if element is present or false if it is not.
     */
    public boolean checkDashboardIsPresent(){
        try {
            return lbl_Dashboard.isDisplayed();
        }catch(Exception e){
            final String ERROR_MESSAGE = "there was an error finding dashboard label";
            throw new Error(ERROR_MESSAGE,e);
        }
    }
}
