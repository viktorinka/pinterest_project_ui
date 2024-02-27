package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/${env}.properties"
})
public interface WebDriverConfig extends Config {
    @Key("baseUrl")
    @DefaultValue("https://pinterest.com/")
    String baseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    String browser();

    @Key("version")
    @DefaultValue("113")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("remoteUrl")
    String remoteUrl();

    @Key("isRemote")
    Boolean isRemote();
}
