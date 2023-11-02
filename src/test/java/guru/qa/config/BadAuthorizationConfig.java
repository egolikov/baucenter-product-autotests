package guru.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({
            "classpath:credentials.properties"
    })

    public interface BadAuthorizationConfig extends Config {

        @Key("BadUserName")
        String BadUserName();

        @Key("BadPassword")
        String BadPassword();

}
