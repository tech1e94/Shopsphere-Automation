package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Lookup order: -Dkey=value  ->  environment variable (KEY_NAME)  ->  config.properties
 * e.g. mvn test -Dheadless=true   or   env var USER_PASSWORD overrides user.password
 */
public final class ConfigReader {
    private static final Properties PROPS = new Properties();

    static {
        try (InputStream in = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (in == null) {
                throw new IllegalStateException("config.properties not found on classpath");
            }
            PROPS.load(in);
        } catch (IOException e) {
            throw new RuntimeException("Could not load config.properties", e);
        }
    }

    private ConfigReader() {}

    public static String get(String key) {
        String sys = System.getProperty(key);
        if (sys != null) return sys;

        String env = System.getenv(key.toUpperCase().replace('.', '_'));
        if (env != null) return env;

        return PROPS.getProperty(key);
    }
}
