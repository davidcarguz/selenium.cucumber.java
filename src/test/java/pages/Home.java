package pages;

import com.aventstack.extentreports.ExtentTest;
import core.CreateReport;
import core.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Home extends WebDriverFactory {

    CreateReport createReport;

    @FindBy(how = How.TAG_NAME, using = "h1")
    private WebElement lbl_Dashboard;

    public Home(CreateReport createReport) {
        this.createReport = createReport;
    }

    /**
     * Checks if the Dashboard element is displayed.
     * @return True if element is present or false if it is not.
     */
    public boolean checkDashboardIsPresent(){
        try {
            boolean found = lbl_Dashboard.isDisplayed();
            if(found){
                createReport.test.pass("The login is working properly.");
            }else{
                createReport.test.fail("There is a problem with the login.");
            }
            return found;
        }catch(Exception e){
            final String ERROR_MESSAGE = "there was an error finding dashboard label";
            throw new Error(ERROR_MESSAGE,e);
        }
    }
}
