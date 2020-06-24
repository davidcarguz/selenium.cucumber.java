package step_definitions;

import core.PropertiesManagement;
import core.WebDriverFactory;
import io.cucumber.java8.En;

public class Hooks extends WebDriverFactory implements En {

    public Hooks(WebDriverFactory webDriverFactory, PropertiesManagement propertiesManagement) {
        Before(()->{
            propertiesManagement.setPropertiesFromFile();
            webDriverFactory.startDriver();
        });

        After(()->{
            webDriverFactory.closeDriver();
        });
    }
}
