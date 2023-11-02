package guru.qa.config;

import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.ConfigCache;

public enum ConfigManager {
    Instance;

    public static final WebConfig webConfig =
            ConfigFactory.create(
                    WebConfig.class,
                    System.getProperties()
            );

    public WebConfig read() {
        return webConfig;
    }

    public static AuthorizationConfig getAuthorization() {
        return ConfigCache.getOrCreate(AuthorizationConfig.class);
    }
}