package step_definitions;

import core.WebDriverFactory;
import io.cucumber.java8.En;

public class Hooks extends WebDriverFactory implements En {

    public Hooks(WebDriverFactory webDriverFactory) {
        Before(()->{
            webDriverFactory.startDriver();
        });

        After(()->{
            webDriverFactory.closeDriver();
        });
    }
}
