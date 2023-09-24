package guru.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({
            "classpath:authorization.properties"
    })

    public interface AuthorizationConfig extends Config {

        @Key("Username")
        String Username();

        @Key("Password")
        String Password();

}
