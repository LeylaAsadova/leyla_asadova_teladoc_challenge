package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * A utility class to create WebDriver instances based on the specified browser type.
 * If no browser type is specified, it defaults to a local ChromeDriver instance.
 */
public class BrowserFactory {

    private static String seleniumGridUrl = ConfigurationReader.getProperty("seleniumgrid.url");

    /**
     * Creates a WebDriver instance based on the specified browser type.
     * If no browser type is specified, a local ChromeDriver instance is created.
     *
     * @return a WebDriver instance, or null if an error occurs during creation.
     */
    public static WebDriver createInstance() {

            WebDriver driver = null;

            try {
                if (driver == null) {
                    // Check if the browser type is specified via system property
                    if(System.getProperty("browser")==null){
                        // Default to local ChromeDriver
                        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                        chromePrefs.put("download.default_directory", System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\Downloads");
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--ignore-ssl-errors=yes");
                        options.addArguments("--ignore-certificate-errors");
                        options.setExperimentalOption("prefs", chromePrefs);
                        driver = new ChromeDriver(options);
                    }
                    else {
                        // Handle different browser types
                        switch (System.getProperty("browser")) {
                            // Remote ChromeDriver setup
                            case "chromeRemote":
                                HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                                chromePrefs.put("download.default_directory", System.getProperty("user.dir")+"\\src\\test\\resources\\test-data\\Downloads");
                                ChromeOptions chrOptions = new ChromeOptions();
                                chrOptions.addArguments("--ignore-ssl-errors=yes");
                                chrOptions.addArguments("--ignore-certificate-errors");
                                chrOptions.setExperimentalOption("prefs", chromePrefs);
                                try {
                                    driver = new RemoteWebDriver(new URL(seleniumGridUrl), chrOptions);
                                } catch (MalformedURLException e) {
                                    e.printStackTrace();
                                }
                                break;

                            default:
                                driver = new ChromeDriver();
                                break;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return driver;
        }
    }