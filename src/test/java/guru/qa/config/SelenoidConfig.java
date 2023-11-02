package guru.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "selenoid.properties"
})

public interface SelenoidConfig extends Config {

    @Key("userName")
    String getUserName();

    @Key("password")
    String getPassword();

    @Key("remoteUrl")
    String getRemoteUrl();
}
