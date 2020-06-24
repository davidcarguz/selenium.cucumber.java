package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    public static WebDriver driver;

    /**
     * Instanciates the driver, sets the basic configuration.
     * sets the implicit wait, maximize window and the url.
     */
    public void startDriver(){
        driver = setDriver(System.getProperty("browser"));
        if(driver != null) {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(System.getProperty("wait.implicit")), TimeUnit.SECONDS);
            driver.get(System.getProperty("url"));
        }else{
            throw new Error("Driver could not be created.");
        }
    }

    /**
     * Instantiate the selenium PageFactory.
     */
    public void initialize(){
        PageFactory.initElements(driver,this);
    }

    /**
     * Closes the open browser windows.
     */
    public void closeDriver(){
        driver.quit();
    }

    /**
     * Instantiates the driver with the desired browser.
     * @param browser Browser where the test are going to be executed.
     * @return Webdriver instantiated with defined browser.
     */
    public WebDriver setDriver(String browser){
        WebDriver driver;
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else
            if(browser.equalsIgnoreCase("firefox")){
                WebDriverManager.firefoxdriver().arch32().setup();
                driver = new FirefoxDriver();
        }else
            if(browser.equalsIgnoreCase("edge")){
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }else{
                driver = null;
            }
        return driver;
    }
}
