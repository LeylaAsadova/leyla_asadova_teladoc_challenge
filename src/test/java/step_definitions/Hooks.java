package step_definitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

/**
 * Hooks class contains methods that run before and after each Cucumber scenario.
 * It sets up and tears down the WebDriver instance, and handles screenshot capture for failed scenarios.
 */
public class Hooks {

    // WebDriver instance for the current scenario
    public WebDriver driver = null;

    /**
     * Method to set up the WebDriver instance before each scenario.
     * Initializes the WebDriver, sets it to the Driver singleton, and configures basic settings.
     */
    @Before
    public void setUp() {
        // Create a WebDriver instance using BrowserFactory
        driver = BrowserFactory.createInstance();
        // Set the WebDriver instance to the Driver singleton
        Driver.getInstance().setDriver(driver);
        // Retrieve the WebDriver instance from the Driver singleton
        driver = Driver.getInstance().getDriver();

        // Configure the WebDriver instance
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /**
     * Method to tear down the WebDriver instance after each scenario.
     * If the scenario has failed, it captures a screenshot and attaches it to the scenario.
     * Finally, it removes the WebDriver instance from the Driver singleton.
     *
     * @param scenario the current Cucumber scenario
     */
    @After
    public void tearDown(Scenario scenario) {
        // If the scenario has failed, capture a screenshot attach to report
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        // Remove the WebDriver instance from the Driver singleton
        Driver.getInstance().removeDriver();
    }
}