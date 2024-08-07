package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * A utility class to read configuration properties from a file.
 * The properties are loaded from the specified file and can be accessed using the `getProperty` method.
 */
public class ConfigurationReader {

    // Properties object to hold the configuration key-value pairs.
    private static Properties properties;

    /**
     * Retrieves the value of the specified property key from the configuration file.
     *
     * @param key the property key whose value is to be retrieved.
     * @return the value of the specified property key, or null if the key is not found.
     */
    public static String getProperty(String key) {
        try {
            String path = "src/test/resources/config.properties";
            // Create a FileInputStream to read the file
            FileInputStream stream = new FileInputStream(path);
            // Initialize the Properties object
            properties = new Properties();
            // Load the properties from the file
            properties.load(stream);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Return the property value corresponding to the key
        return properties.getProperty(key);
    }
}