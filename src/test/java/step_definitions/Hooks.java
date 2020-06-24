package step_definitions;

import core.CreateReport;
import core.PropertiesManagement;
import core.WebDriverFactory;
import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;

public class Hooks extends WebDriverFactory implements En {

    public Hooks(WebDriverFactory webDriverFactory, PropertiesManagement propertiesManagement, CreateReport createReport) {
        Before((Scenario scenario)->{
            propertiesManagement.setPropertiesFromFile();
            createReport.setupReport();
            createReport.setTest(scenario.getName());
            webDriverFactory.startDriver();
            createReport.getTest().info("Navego a la pagina inicial "+System.getProperty("url"));
        });

        After((Scenario scenario)->{
            webDriverFactory.closeDriver();
            createReport.report.flush();
        });
    }
}
