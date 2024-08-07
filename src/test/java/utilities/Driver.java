package utilities;

import org.openqa.selenium.WebDriver;

/**
 * A singleton utility class that manages WebDriver instances using ThreadLocal.
 * Ensures that each thread has its own WebDriver instance to avoid conflicts in
 * multi-threaded environments such as parallel test execution.
 */
public class Driver {

    // Private constructor to prevent instantiation from outside the class.
    private Driver() {
    }

    // The single instance of the Driver class, created eagerly at class loading time.
    private static Driver instance = new Driver();

    /**
     * Returns the singleton instance of the Driver class.
     *
     * @return the single instance of the Driver class.
     */
    public static Driver getInstance() {
        return instance;
    }

    // ThreadLocal variable to hold the WebDriver instance for each thread.
    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    /**
     * Retrieves the WebDriver instance associated with the current thread.
     *
     * @return the WebDriver instance for the current thread.
     */
    public WebDriver getDriver() {
        return driver.get();
    }

    /**
     * Sets the WebDriver instance for the current thread.
     *
     * @param driverParameter the WebDriver instance to be associated with the current thread.
     */
    public void setDriver(WebDriver driverParameter) {
        driver.set(driverParameter);
    }

    /**
     * Quits the WebDriver instance and removes it from the current thread.
     * Ensures that resources are properly released and prevents memory leaks.
     */
    public void removeDriver() {
        driver.get().quit();
        driver.remove();
    }
}