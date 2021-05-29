package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/web.properties"
})
public interface WebConfig extends Config{

    @DefaultValue("chrome")
    String webBrowser();

    String webUrl();

    String remoteDriverUrl();
}