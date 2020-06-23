package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

    public static WebDriver driver;

    /**
     * Instanciates the driver, sets the basic configuration.
     * sets the implicit wait, maximize window and the url.
     */
    public void startDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com/");
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
}
